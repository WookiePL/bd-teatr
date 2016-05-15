package bd2.adminPanel.controllers;

import java.io.IOException;

import javafx.application.Platform;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class MenuController {

    @FXML
    private StackPane menuStackPane;

    @FXML
    public void users() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/UsersScreen.fxml"));
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
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/DictionariesScreen.fxml"));
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
