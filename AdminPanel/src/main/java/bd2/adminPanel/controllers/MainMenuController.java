package bd2.adminPanel.controllers;

import bd2.adminPanel.tmp.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class MainMenuController implements Initializable {

    @FXML
    private StackPane menuStackPane;
    
    @FXML
    private Button buttonUsers;

    @FXML
    private Button buttonDictionaries;

    @FXML
    private Button buttonExit;
    
    @FXML
    private Button buttonLogout;

    @FXML
    public void users() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(
                "/fxml/UsersScreen.fxml"));
        StackPane pane = null;

        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        menuStackPane.getChildren().clear();
        menuStackPane.getChildren().add(pane);
    }

    @FXML
    public void dictionaries() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(
                "/fxml/DictionariesScreen.fxml"));
        StackPane pane = null;

        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        menuStackPane.getChildren().clear();
        menuStackPane.getChildren().add(pane);
    }
    
    @FXML
    public void logout() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(
                "/fxml/LoginScreen.fxml"));
        StackPane pane = null;

        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        menuStackPane.getChildren().clear();
        menuStackPane.getChildren().add(pane);
    }

    @FXML
    public void exit() {
        Platform.exit();
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buttonUsers.defaultButtonProperty().bind(buttonUsers.focusedProperty());
        buttonDictionaries.defaultButtonProperty().bind(buttonDictionaries.focusedProperty());
        buttonLogout.defaultButtonProperty().bind(buttonLogout.focusedProperty());
        buttonExit.defaultButtonProperty().bind(buttonExit.focusedProperty());
        Platform.runLater(() -> {
            buttonUsers.requestFocus();
        });
    }
}
