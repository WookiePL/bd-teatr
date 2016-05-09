package bd2.adminPanel.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import bd2.adminPanel.tmp.Right;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.Pane;

public class EditRightsController implements Initializable {

	private MainController mainController;
	private FXMLLoader loader;
	private UsersController usersController;
	private Pane pane = null;

	@FXML
	private CheckBox checkBox1;
	@FXML
	private CheckBox checkBox2;
	@FXML
	private CheckBox checkBox3;
	@FXML
	private CheckBox checkBox4;
	@FXML
	private CheckBox checkBox5;

	private ObservableSet<CheckBox> selectedCheckBoxes = FXCollections.observableSet();
	private ObservableSet<CheckBox> unselectedCheckBoxes = FXCollections.observableSet();
	
	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}
	
	@Override
	public void initialize(java.net.URL location, java.util.ResourceBundle resources) {
		init();

		List<Right> rights = usersController.getSelectedUser().getRights();

		if (rights != null) {
			for (Right right : rights) {
				if (right.getId().equals("1")) {
					checkBox1.setSelected(true);
				} else if (right.getId().equals("2")) {
					checkBox2.setSelected(true);
				} else if (right.getId().equals("3")) {
					checkBox3.setSelected(true);
				} else if (right.getId().equals("4")) {
					checkBox4.setSelected(true);
				} else if (right.getId().equals("5")) {
					checkBox5.setSelected(true);
				}
			}
		}

		configureCheckBox(checkBox1);
		configureCheckBox(checkBox2);
		configureCheckBox(checkBox3);
		configureCheckBox(checkBox4);
		configureCheckBox(checkBox5);
	}

	private void configureCheckBox(CheckBox checkBox) {
		if (checkBox.isSelected()) {
			selectedCheckBoxes.add(checkBox);
		} else {
			unselectedCheckBoxes.add(checkBox);
		}

		checkBox.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {
			if (isNowSelected) {
				unselectedCheckBoxes.remove(checkBox);
				selectedCheckBoxes.add(checkBox);
			} else {
				selectedCheckBoxes.remove(checkBox);
				unselectedCheckBoxes.add(checkBox);
			}

		});

	}

	@FXML
	public void backToUsers() {
		init();
		mainController.setScreen(pane);
	}

	@FXML
	public void confirm() {
		init();
		
		List<Right> rights = new ArrayList<>();

		for (CheckBox box : selectedCheckBoxes) {
			if (box.getId().equals("checkBox1")) {
				rights.add(new Right(Right.RIGHT_1_ID, Right.RIGHT_1_ID, Right.RIGHT_1_ID));
			} else if (box.getId().equals("checkBox2")) {
				rights.add(new Right(Right.RIGHT_2_ID, Right.RIGHT_2_ID, Right.RIGHT_2_ID));
			} else if (box.getId().equals("checkBox3")) {
				rights.add(new Right(Right.RIGHT_3_ID, Right.RIGHT_3_ID, Right.RIGHT_3_ID));
			} else if (box.getId().equals("checkBox4")) {
				rights.add(new Right(Right.RIGHT_4_ID, Right.RIGHT_4_ID, Right.RIGHT_4_ID));
			} else {
				rights.add(new Right(Right.RIGHT_5_ID, Right.RIGHT_5_ID, Right.RIGHT_5_ID));
			}
		}

		usersController.getSelectedUser().setRights(rights);

		ObservableList<Right> rightsList = FXCollections.observableArrayList();
		rightsList.addAll(rights);

		usersController.getListViewRights().setItems(rightsList);

		mainController.setScreen(pane);
	}
	
	private void init() {
		loader = new FXMLLoader(this.getClass().getResource("/fxml/UsersScreen.fxml"));

		try {
			pane = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}

		usersController = loader.getController();
		usersController.setMainController(mainController);
	}
}
