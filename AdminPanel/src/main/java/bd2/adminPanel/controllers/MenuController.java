package bd2.adminPanel.controllers;

import java.io.IOException;

import javafx.application.Platform;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

public class MenuController {

    private MainController mainController;

    @FXML
    public void users() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/UsersScreen.fxml"));
        Pane pane = null;

        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        UsersController usersController = loader.getController();
        usersController.setMainController(mainController);

        mainController.setScreen(pane);
    }

    @FXML
    public void dictionaries() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/DictionariesScreen.fxml"));
        Pane pane = null;

        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        DictionariesController dictionariesController = loader.getController();
        dictionariesController.setMainController(mainController);

        mainController.setScreen(pane);
    }

    @FXML
    public void exit() {
        Platform.exit();
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
