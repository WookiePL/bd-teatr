package bd2.adminPanel.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

/**
 * Class 
 */
public class DictionariesController implements Initializable {

	private static AnnotationConfigApplicationContext context;

	@FXML
	private StackPane dictionariesStackPane;

	@FXML
	private Button buttonBackMenu;

	@FXML
	private Button buttonDaysOfWeek;

	@FXML
	private Button buttonGroupsOfClients;

	@FXML
	private Button buttonEventTypes;

	@FXML
	private Button buttonBuildings;

	@FXML
	public void daysOfWeek() {
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/DictonaryDaysOfWeekScreen.fxml"));
		StackPane pane = null;

		try {
			pane = loader.load();
			((DictonaryDaysOfWeekController) loader.getController()).setContext(context);
		} catch (IOException e) {
			e.printStackTrace();
		}

		dictionariesStackPane.getChildren().clear();
		dictionariesStackPane.getChildren().add(pane);
	}

	@FXML
	public void GroupsOfClients() {
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/DictonaryGroupsOfClientsScreen.fxml"));
		StackPane pane = null;

		try {
			pane = loader.load();
			((DictonaryGroupsOfClientsController) loader.getController()).setContext(context);
		} catch (IOException e) {
			e.printStackTrace();
		}

		dictionariesStackPane.getChildren().clear();
		dictionariesStackPane.getChildren().add(pane);
	}

	@FXML
	public void EventTypes() {
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/DictonaryEventTypesScreen.fxml"));
		StackPane pane = null;

		try {
			pane = loader.load();
			((DictonaryEventTypesController) loader.getController()).setContext(context);
		} catch (IOException e) {
			e.printStackTrace();
		}

		dictionariesStackPane.getChildren().clear();
		dictionariesStackPane.getChildren().add(pane);
	}

	@FXML
	public void Buildings() {
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/DictonaryBuildingsScreen.fxml"));
		StackPane pane = null;

		try {
			pane = loader.load();
			((DictonaryBuildingsController) loader.getController()).setContext(context);
		} catch (IOException e) {
			e.printStackTrace();
		}

		dictionariesStackPane.getChildren().clear();
		dictionariesStackPane.getChildren().add(pane);
	}

	@FXML
	public void backMenu() {
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/MainMenuScreen.fxml"));
		StackPane pane = null;

		try {
			pane = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}

		dictionariesStackPane.getChildren().clear();
		dictionariesStackPane.getChildren().add(pane);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		buttonBackMenu.defaultButtonProperty().bind(buttonBackMenu.focusedProperty());
		buttonDaysOfWeek.defaultButtonProperty().bind(buttonDaysOfWeek.focusedProperty());
		buttonGroupsOfClients.defaultButtonProperty().bind(buttonGroupsOfClients.focusedProperty());
		buttonEventTypes.defaultButtonProperty().bind(buttonEventTypes.focusedProperty());
		buttonBuildings.defaultButtonProperty().bind(buttonBuildings.focusedProperty());
		Platform.runLater(() -> {
			buttonDaysOfWeek.requestFocus();
		});
	}

	public void setContext(AnnotationConfigApplicationContext context) {
		this.context = context;
	}

}
