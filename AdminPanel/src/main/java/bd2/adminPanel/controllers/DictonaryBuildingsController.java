/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd2.adminPanel.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class DictonaryBuildingsController {

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
    public void back() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(
                "/fxml/DictionariesScreen.fxml"));
        StackPane pane = null;

        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        dictionariesStackPane.getChildren().clear();
        dictionariesStackPane.getChildren().add(pane);
    }
}
