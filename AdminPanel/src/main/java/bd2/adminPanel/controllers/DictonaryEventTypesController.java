/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd2.adminPanel.controllers;

import bd2.adminPanel.dao.EventTypeDAO;
import bd2.adminPanel.dao.UserDAO;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

public class DictonaryEventTypesController {

    @FXML
    private StackPane dictionariesStackPane;

    @FXML
    private ListView<EventTypeDAO> listViewEventTypes;

    @FXML
    private TextField textFieldEventTypeName;
    
    @FXML
    private Button buttonAddEventType;

    @FXML
    private Button buttonEditEventType;

    @FXML
    private Button buttonDeleteEventType;

    @FXML
    private Button buttonBackMenu;

    @FXML
    public void addEventType() {
    }
    
    @FXML
    public void editEventType() {
    }
    
    @FXML
    public void deleteEventType() {
    }
    
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
