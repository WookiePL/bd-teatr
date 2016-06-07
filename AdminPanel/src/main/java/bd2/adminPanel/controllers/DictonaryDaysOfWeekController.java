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
import bd2.adminPanel.dao.dictionaries.DayOfWeekDAO;
import bd2.adminPanel.dao.repository.DaysOfWeekRepository;
import java.util.Collections;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

public class DictonaryDaysOfWeekController implements Initializable {

    private AnnotationConfigApplicationContext context;
    private DBUtils dbUtils;
    private DaysOfWeekRepository daysOfWeekRepository;

    @FXML
    private StackPane dictionariesStackPane;

    @FXML
    private ListView<DayOfWeekDAO> listViewDaysOfWeek;

    @FXML
    private TextField textFieldDayOfWeekID;
    
    @FXML
    private TextField textFieldDayOfWeekName;

    @FXML
    private Button buttonAddDayOfWeek;

    @FXML
    private Button buttonEditDayOfWeek;

    @FXML
    private Button buttonDeleteDayOfWeek;

    @FXML
    private Button buttonBackMenu;

    @FXML
    public void detailDayOfWeek() {
        
    }
    
    @FXML
    public void addDayOfWeek() {
        DayOfWeekDAO day = new DayOfWeekDAO(
                Integer.parseInt(textFieldDayOfWeekID.getText()),
                textFieldDayOfWeekName.getText()
        );
        dbUtils.persist(day);
        initialize(null, null);
    }

    @FXML
    public void editDayOfWeek() {
        DayOfWeekDAO day = listViewDaysOfWeek.getSelectionModel().getSelectedItem();
        if (day != null) {
            day.setName(textFieldDayOfWeekName.getText());
            dbUtils.persist(day);
            initialize(null, null);
        }
    }

    @FXML
    public void deleteDayOfWeek() {
        DayOfWeekDAO day = listViewDaysOfWeek.getSelectionModel().getSelectedItem();

        if (day != null) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.getButtonTypes().set(0, new ButtonType("Tak", ButtonBar.ButtonData.YES));
            alert.getButtonTypes().set(1, new ButtonType("Nie", ButtonBar.ButtonData.NO));
            alert.setTitle("Usun¹æ?");
            alert.setHeaderText("Czy na pewno chcesz usun¹æ dzieñ tygodnia?");
            alert.setContentText("Nazwa: " + day.getName());
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.getStylesheets().add(getClass().getResource("/fxml/GreenButton.css").toExternalForm());

            alert.showAndWait().ifPresent(rs -> {
                if (rs.getButtonData() == ButtonBar.ButtonData.YES) {
                    dbUtils.remove(day);
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
        dbUtils = context.getBean("DBUtils", DBUtils.class);
        daysOfWeekRepository = context.getBean("daysOfWeekRepository", DaysOfWeekRepository.class);
        initialize(null, null);
    }

    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<DayOfWeekDAO> days = FXCollections.observableArrayList();

        if (dbUtils != null) {
            List<DayOfWeekDAO> tmp_days = daysOfWeekRepository.getDaysOfWeek();
            days.addAll(tmp_days);
            Collections.sort(days);
        }

        listViewDaysOfWeek.setItems(days);
        listViewDaysOfWeek.refresh();
    }

}
