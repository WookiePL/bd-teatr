package bd2.adminPanel.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class DictionariesController implements Initializable {

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
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(
                "/fxml/DictonaryDaysOfWeekScreen.fxml"));
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
    public void GroupsOfClients() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(
                "/fxml/DictonaryGroupsOfClientsScreen.fxml"));
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
    public void EventTypes() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(
                "/fxml/DictonaryEventTypesScreen.fxml"));
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
    public void Buildings() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(
                "/fxml/DictonaryBuildingsScreen.fxml"));
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
    public void backMenu() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(
                "/fxml/MainMenuScreen.fxml"));
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
        buttonBackMenu.defaultButtonProperty()
                .bind(buttonBackMenu.focusedProperty());
        buttonDaysOfWeek.defaultButtonProperty()
                .bind(buttonDaysOfWeek.focusedProperty());
        buttonGroupsOfClients.defaultButtonProperty()
                .bind(buttonGroupsOfClients.focusedProperty());
        buttonEventTypes.defaultButtonProperty()
                .bind(buttonEventTypes.focusedProperty());
        buttonBuildings.defaultButtonProperty()
                .bind(buttonBuildings.focusedProperty());
        Platform.runLater(() -> {
            buttonDaysOfWeek.requestFocus();
        });
    }
}
