package bd2.adminPanel.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import bd2.adminPanel.dao.DBUtils;
import bd2.adminPanel.dao.repository.BuildingsRepository;
import bd2.adminPanel.dao.repository.PlacesRepository;
import bd2.adminPanel.dao.repository.RoomsRepository;
import bd2.adminPanel.dao.repository.SectorsRepository;
import bd2.adminPanel.model.dictionaries.Building;
import bd2.adminPanel.model.dictionaries.Place;
import bd2.adminPanel.model.dictionaries.Room;
import bd2.adminPanel.model.dictionaries.Sector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

public class DictonaryBuildingsController {

	private AnnotationConfigApplicationContext context;
	private DBUtils dbUtils;
	private BuildingsRepository buildingsRepository;
	private RoomsRepository roomsRepository;
	private SectorsRepository sectorsRepository;
	private PlacesRepository placesRepository;

	@FXML
	private StackPane dictionariesStackPane;

	@FXML
	private Button buttonBackMenu;

	@FXML
	private Button buttonAddBuilding;

	@FXML
	private Button buttonEditBuilding;

	@FXML
	private Button buttonDeleteBuilding;

	@FXML
	private Button buttonAddRoom;

	@FXML
	private Button buttonEditRoom;

	@FXML
	private Button buttonDeleteRoom;

	@FXML
	private Button buttonAddSector;

	@FXML
	private Button buttonEditSector;

	@FXML
	private Button buttonDeleteSector;

	@FXML
	private ListView<Building> listViewBuildings;

	@FXML
	private ListView<Room> listViewRooms;

	@FXML
	private ListView<Sector> listViewSectors;

	@FXML
	private TextField textFieldBuildingAddress;

	@FXML
	private TextField textFieldRoomNumber;

	@FXML
	private TextField textFieldSectorNumber;

	@FXML
	private TextField textFieldSectorSizeX;

	@FXML
	private TextField textFieldSectorSizeY;
	
	@FXML
	private Label labelError;

	@FXML
	public void back() {
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/DictionariesScreen.fxml"));
		StackPane pane = null;

		try {
			pane = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}

		dictionariesStackPane.getChildren().clear();
		dictionariesStackPane.getChildren().add(pane);
	}

	@FXML
	public void buildingDetail() {
		Building building = listViewBuildings.getSelectionModel().getSelectedItem();
		textFieldBuildingAddress.setText(building.getAddress());
		roomDetail();
	}

	@FXML
	public void roomDetail() {
		Building building = listViewBuildings.getSelectionModel().getSelectedItem();
		Room room = listViewRooms.getSelectionModel().getSelectedItem();

		if (room != null) {
			textFieldRoomNumber.setText(room.getNumber().toString());
		}

		if (building != null) {
			ObservableList<Room> rooms = FXCollections.observableArrayList();
			rooms.addAll(roomsRepository.findRoomByBuildingId(building.getBuildingId()));
			listViewRooms.setItems(rooms);
			listViewRooms.refresh();
		} else {
			listViewRooms.setItems(null);
			listViewRooms.refresh();
		}
		sectorDetail();
	}

	@FXML
	public void sectorDetail() {
		Room room = listViewRooms.getSelectionModel().getSelectedItem();
		Sector sector = listViewSectors.getSelectionModel().getSelectedItem();

		if (sector != null) {
			textFieldSectorNumber.setText(sector.getNumber().toString());
			textFieldSectorSizeX.setText(sector.getSize_X().toString());
			textFieldSectorSizeY.setText(sector.getSize_Y().toString());
		}

		if (room != null) {
			ObservableList<Sector> sectors = FXCollections.observableArrayList();
			sectors.addAll(sectorsRepository.findSectorByRoomId(room.getRoomId()));
			listViewSectors.setItems(sectors);
			listViewSectors.refresh();
		} else {
			listViewSectors.setItems(null);
			listViewSectors.refresh();
		}
	}

	@FXML
	public void addBuilding() {
		String address = textFieldBuildingAddress.getText();
		if(address.length() > 0) {
			Building building = new Building();
			building.setAddress(address);
			building.setRooms(new ArrayList<>());
			dbUtils.persist(building);
			initialize(null, null);
		}
	}

	@FXML
	public void editBuilding() {
		String address = textFieldBuildingAddress.getText();
		Building building = listViewBuildings.getSelectionModel().getSelectedItem();
		if(address.length() > 0 && building != null) {
			building.setAddress(address);
			dbUtils.persist(building);
			initialize(null, null);
		}
	}

	@FXML
	public void deleteBuilding() {
		Building building = listViewBuildings.getSelectionModel().getSelectedItem();

		if (building != null) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.getButtonTypes().set(0, new ButtonType("Tak", ButtonBar.ButtonData.YES));
			alert.getButtonTypes().set(1, new ButtonType("Nie", ButtonBar.ButtonData.NO));
			alert.setTitle("Usun号?");
			alert.setHeaderText("Czy na pewno chcesz usun号 budynek?");
			alert.setContentText("Address: " + building.getAddress());
			DialogPane dialogPane = alert.getDialogPane();
			dialogPane.getStylesheets().add(getClass().getResource("/fxml/GreenButton.css").toExternalForm());

			alert.showAndWait().ifPresent(rs -> {
				if (rs.getButtonData() == ButtonBar.ButtonData.YES) {
					dbUtils.remove(building);
					initialize(null, null);
				}
			});
		}
	}

	@FXML
	public void addRoom() {
		try {
			Building building = listViewBuildings.getSelectionModel().getSelectedItem();
			if(building != null && textFieldRoomNumber.getText().length() > 0) {
				Integer number = Integer.parseInt(textFieldRoomNumber.getText());
				Room room = new Room();
				room.setNumber(number);
				room.setBuildingId(building.getBuildingId());
				room.setSectors(new ArrayList<>());
				building.getRooms().add(room);
				dbUtils.persist(room);
				dbUtils.persist(building);
				labelError.setVisible(false);
				roomDetail();
			}
		} catch(Exception e) {
			labelError.setVisible(true);
		}
	}

	@FXML
	public void editRoom() {
		try {
			Room room = listViewRooms.getSelectionModel().getSelectedItem();
			if(room != null && textFieldRoomNumber.getText().length() > 0) {
				Integer number = Integer.parseInt(textFieldRoomNumber.getText());
				room.setNumber(number);
				dbUtils.persist(room);
				labelError.setVisible(false);
				roomDetail();
				
			}
		} catch(Exception e) {
			labelError.setVisible(true);
		}
	}

	@FXML
	public void deleteRoom() {
		Room room = listViewRooms.getSelectionModel().getSelectedItem();

		if (room != null) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.getButtonTypes().set(0, new ButtonType("Tak", ButtonBar.ButtonData.YES));
			alert.getButtonTypes().set(1, new ButtonType("Nie", ButtonBar.ButtonData.NO));
			alert.setTitle("Usun号?");
			alert.setHeaderText("Czy na pewno chcesz usun号 pomieszczenie?");
			alert.setContentText("Numer: " + room.getNumber());
			DialogPane dialogPane = alert.getDialogPane();
			dialogPane.getStylesheets().add(getClass().getResource("/fxml/GreenButton.css").toExternalForm());

			alert.showAndWait().ifPresent(rs -> {
				if (rs.getButtonData() == ButtonBar.ButtonData.YES) {
					dbUtils.remove(room);
					roomDetail();
				}
			});
		}
	}

	@FXML
	public void addSector() {
		try {
			Room room = listViewRooms.getSelectionModel().getSelectedItem();
			if(room != null && textFieldSectorNumber.getText().length() > 0 && textFieldSectorSizeX.getText().length() > 0 && textFieldSectorSizeY.getText().length() > 0) {
				Integer number = Integer.parseInt(textFieldSectorNumber.getText());
				Integer sizeX = Integer.parseInt(textFieldSectorSizeX.getText());
				Integer sizeY = Integer.parseInt(textFieldSectorSizeY.getText());
				Sector sector = new Sector();
				sector.setNumber(number);
				sector.setRoomId(room.getRoomId());
				sector.setSize_X(sizeX);
				sector.setSize_Y(sizeY);
				
				dbUtils.persist(sector);
				
				List<Place> places =  new ArrayList<>();
				for(int i = 0; i < sizeX * sizeY; ++i) {
					Place place = new Place();
					place.setNumber(i);
					place.setSectorId(sector.getSectorId());
					places.add(place);
					dbUtils.persist(place);
				}
				labelError.setVisible(false);
				sector.setPlaces(places);
				room.getSectors().add(sector);
					
				dbUtils.persist(room);
				sectorDetail();
				
			}
		} catch(Exception e) {
			labelError.setVisible(true);
		}
	}

	@FXML
	public void editSector() {
		try {
			Sector sector = listViewSectors.getSelectionModel().getSelectedItem();
			if(sector != null && textFieldSectorNumber.getText().length() > 0 && textFieldSectorSizeX.getText().length() > 0 && textFieldSectorSizeY.getText().length() > 0) {
				for(int i = 0; i < sector.getSize_X() * sector.getSize_Y(); ++i) {		
					dbUtils.remove(placesRepository.findPlaceBySectorId(sector.getSectorId()).get(i));
				}
		
				Integer number = Integer.parseInt(textFieldSectorNumber.getText());
				sector.setNumber(number);
		
				Integer sizeX = Integer.parseInt(textFieldSectorSizeX.getText());
				sector.setSize_X(sizeX);
		
				Integer sizeY = Integer.parseInt(textFieldSectorSizeY.getText());
				sector.setSize_Y(sizeY);
				
				List<Place> places =  new ArrayList<>();
				for(int i = 0; i < sizeX * sizeY; ++i) {
					Place place = new Place();
					place.setNumber(i);
					place.setSectorId(sector.getSectorId());
					places.add(place);
					dbUtils.persist(place);
				}
				labelError.setVisible(false);
				sector.setPlaces(places);
				dbUtils.persist(sector);
				sectorDetail();
			}
		} catch(Exception e) {
			labelError.setVisible(true);
		}
	}

	@FXML
	public void deleteSector() {
		Sector sector = listViewSectors.getSelectionModel().getSelectedItem();

		if (sector != null) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.getButtonTypes().set(0, new ButtonType("Tak", ButtonBar.ButtonData.YES));
			alert.getButtonTypes().set(1, new ButtonType("Nie", ButtonBar.ButtonData.NO));
			alert.setTitle("Usun号?");
			alert.setHeaderText("Czy na pewno chcesz usun号 sektor?");
			alert.setContentText("Numer: " + sector.getNumber());
			DialogPane dialogPane = alert.getDialogPane();
			dialogPane.getStylesheets().add(getClass().getResource("/fxml/GreenButton.css").toExternalForm());

			alert.showAndWait().ifPresent(rs -> {
				if (rs.getButtonData() == ButtonBar.ButtonData.YES) {
					dbUtils.remove(sector);
					sectorDetail();
				}
			});
		}
	}

	public void setContext(AnnotationConfigApplicationContext context) {
		this.context = context;
		dbUtils = this.context.getBean("DBUtils", DBUtils.class);
		buildingsRepository = this.context.getBean("buildingsRepository", BuildingsRepository.class);
		roomsRepository = this.context.getBean("roomsRepository", RoomsRepository.class);
		sectorsRepository = this.context.getBean("sectorsRepository", SectorsRepository.class);
		placesRepository = this.context.getBean("placesRepository", PlacesRepository.class);
		initialize(null, null);
	}

	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<Building> buildings = FXCollections.observableArrayList();

		if (dbUtils != null) {
			List<Building> tmp_buildings = buildingsRepository.getBuildings();
			Collections.sort(tmp_buildings);
			buildings.addAll(tmp_buildings);
		}

		listViewBuildings.setItems(buildings);
		listViewBuildings.refresh();
	}

}
