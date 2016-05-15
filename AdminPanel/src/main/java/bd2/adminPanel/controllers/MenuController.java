package bd2.adminPanel.controllers;

import java.io.IOException;

import javafx.application.Platform;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class MenuController {

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
    
    private final DropShadow shadow = new DropShadow(BlurType.THREE_PASS_BOX,
            Color.rgb(0, 0, 0, 0.4), 5, 0.0, 0, 1);

    private final String greenButtonReleasedStyle = "-fx-background-color: "
            + "linear-gradient(#f0ff35, #a9ff00), radial-gradient(center 50% "
            + "-40%, radius 200%, #b8ee36 45%, #80c800 50%); -fx-background-"
            + "radius: 6, 5; -fx-background-insets: 0, 1; -fx-text-fill: "
            + "#395306;";

    private final String greenButtonPressedStyle = "-fx-background-color: "
            + "linear-gradient(#a9ff00, #f0ff35), radial-gradient(center 50% "
            + "+140%, radius 200%, #b8ee36 45%, #80c800 50%); -fx-background-"
            + "radius: 6, 5; -fx-background-insets: 0, 1; -fx-text-fill: "
            + "#395306";

    private final String greenButtonOnMouseStyle = "-fx-background-color: "
            + "linear-gradient(#f4ff57, #caff38), radial-gradient(center 50% "
            + "-40%, radius 200%, #ceff52 45%, #92e600 50%); -fx-background-"
            + "radius: 6, 5; -fx-background-insets: 0, 1; -fx-text-fill: "
            + "#395306";
    
    @FXML
    public void buttonUsersOnMouseEntered() {
        buttonUsers.setEffect(shadow);
        buttonUsers.setStyle(greenButtonOnMouseStyle);
    }

    @FXML
    public void buttonUsersOnMouseExited() {
        buttonUsers.setEffect(null);
        buttonUsers.setStyle(greenButtonReleasedStyle);
    }

    @FXML
    public void buttonUsersOnMousePressed() {
        buttonUsers.setStyle(greenButtonPressedStyle);
    }

    @FXML
    public void buttonUsersOnMouseReleased() {
        buttonUsers.setStyle(greenButtonReleasedStyle);
    }

    @FXML
    public void buttonDictionariesOnMouseEntered() {
        buttonDictionaries.setEffect(shadow);
        buttonDictionaries.setStyle(greenButtonOnMouseStyle);
    }

    @FXML
    public void buttonDictionariesOnMouseExited() {
        buttonDictionaries.setEffect(null);
        buttonDictionaries.setStyle(greenButtonReleasedStyle);
    }

    @FXML
    public void buttonDictionariesOnMousePressed() {
        buttonDictionaries.setStyle(greenButtonPressedStyle);
    }

    @FXML
    public void buttonDictionariesOnMouseReleased() {
        buttonDictionaries.setStyle(greenButtonReleasedStyle);
    }

    @FXML
    public void buttonExitOnMouseEntered() {
        buttonExit.setEffect(shadow);
        buttonExit.setStyle(greenButtonOnMouseStyle);
    }

    @FXML
    public void buttonExitOnMouseExited() {
        buttonExit.setEffect(null);
        buttonExit.setStyle(greenButtonReleasedStyle);
    }

    @FXML
    public void buttonExitOnMousePressed() {
        buttonExit.setStyle(greenButtonPressedStyle);
    }

    @FXML
    public void buttonExitOnMouseReleased() {
        buttonExit.setStyle(greenButtonReleasedStyle);
    }
    
    @FXML
    public void buttonLogoutOnMouseEntered() {
        buttonLogout.setEffect(shadow);
        buttonLogout.setStyle(greenButtonOnMouseStyle);
    }

    @FXML
    public void buttonLogoutOnMouseExited() {
        buttonLogout.setEffect(null);
        buttonLogout.setStyle(greenButtonReleasedStyle);
    }

    @FXML
    public void buttonLogoutOnMousePressed() {
        buttonLogout.setStyle(greenButtonPressedStyle);
    }

    @FXML
    public void buttonLogoutOnMouseReleased() {
        buttonLogout.setStyle(greenButtonReleasedStyle);
    }

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
}
