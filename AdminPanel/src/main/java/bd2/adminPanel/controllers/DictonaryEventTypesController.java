/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd2.adminPanel.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import bd2.adminPanel.dao.DBUtils;
import bd2.adminPanel.dao.dictionaries.EventTypeDAO;
import bd2.adminPanel.dao.repository.EventsTypesRepository;
import java.util.Collections;
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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import org.hibernate.mapping.Collection;

public class DictonaryEventTypesController {

    private AnnotationConfigApplicationContext context;
    private DBUtils dbUtils;
    private EventsTypesRepository eventsTypesRepository;

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
        EventTypeDAO type = new EventTypeDAO(textFieldEventTypeName.getText());
        dbUtils.persist(type);
        initialize(null, null);
    }

    @FXML
    public void editEventType() {
        EventTypeDAO type = listViewEventTypes.getSelectionModel().getSelectedItem();
        if (type != null) {
            type.setName(textFieldEventTypeName.getText());
            dbUtils.persist(type);
            initialize(null, null);
        }
    }

    @FXML
    public void deleteEventType() {
        EventTypeDAO type = listViewEventTypes.getSelectionModel().getSelectedItem();

        if (type != null) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.getButtonTypes().set(0, new ButtonType("Tak", ButtonBar.ButtonData.YES));
            alert.getButtonTypes().set(1, new ButtonType("Nie", ButtonBar.ButtonData.NO));
            alert.setTitle("Usun¹æ?");
            alert.setHeaderText("Czy na pewno chcesz usun¹æ typ wydarzenia?");
            alert.setContentText("Nazwa: " + type.getName());
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.getStylesheets().add(getClass().getResource("/fxml/GreenButton.css").toExternalForm());

            alert.showAndWait().ifPresent(rs -> {
                if (rs.getButtonData() == ButtonBar.ButtonData.YES) {
                    dbUtils.remove(type);
                    initialize(null, null);
                }
            });
        }
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

    public void setContext(AnnotationConfigApplicationContext context) {
        this.context = context;
        dbUtils = this.context.getBean("DBUtils", DBUtils.class);
        eventsTypesRepository = this.context.getBean("eventsTypesRepository", EventsTypesRepository.class);
        initialize(null, null);
    }

    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<EventTypeDAO> types = FXCollections.observableArrayList();

        if (dbUtils != null) {
            List<EventTypeDAO> tmp_groups = eventsTypesRepository.getEventsTypes();
            Collections.sort(tmp_groups);
            types.addAll(tmp_groups);
        }

        listViewEventTypes.setItems(types);
        listViewEventTypes.refresh();
    }
}
