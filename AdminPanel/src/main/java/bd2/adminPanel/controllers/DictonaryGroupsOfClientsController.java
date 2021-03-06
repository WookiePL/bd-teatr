package bd2.adminPanel.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import bd2.adminPanel.dao.DBUtils;
import bd2.adminPanel.dao.repository.GroupsOfClientsRepository;
import bd2.adminPanel.model.dictionaries.GroupOfClient;

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

public class DictonaryGroupsOfClientsController {

    private AnnotationConfigApplicationContext context;
    private DBUtils dbUtils;
    private GroupsOfClientsRepository groupsOfClientsRepository;

    @FXML
    private StackPane dictionariesStackPane;

    @FXML
    private ListView<GroupOfClient> listViewGroupsOfClient;

    @FXML
    private TextField textFieldGroupOfClientName;

    @FXML
    private Button buttonAddGroupOfClient;

    @FXML
    private Button buttonEditGroupOfClient;

    @FXML
    private Button buttonDeleteGroupOfClient;

    @FXML
    private Button buttonBackMenu;

    @FXML
    public void addGroupOfClient() {
    	if(textFieldGroupOfClientName.getText().length() > 0) {
	        GroupOfClient group = new GroupOfClient(textFieldGroupOfClientName.getText());
	        dbUtils.persist(group);
	        initialize(null, null);
    	}
    }

    @FXML
    public void editGroupOfClient() {
        GroupOfClient group = listViewGroupsOfClient.getSelectionModel().getSelectedItem();
        if (group != null && textFieldGroupOfClientName.getText().length() > 0) {
            group.setName(textFieldGroupOfClientName.getText());
            dbUtils.persist(group);
            initialize(null, null);
        }
    }

    @FXML
    public void deleteGroupOfClient() {
        GroupOfClient group = listViewGroupsOfClient.getSelectionModel().getSelectedItem();

        if (group != null) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.getButtonTypes().set(0, new ButtonType("Tak", ButtonBar.ButtonData.YES));
            alert.getButtonTypes().set(1, new ButtonType("Nie", ButtonBar.ButtonData.NO));
            alert.setTitle("Usun��?");
            alert.setHeaderText("Czy na pewno chcesz usun�� grup�?");
            alert.setContentText("Nazwa: " + group.getName());
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.getStylesheets().add(getClass().getResource("/fxml/GreenButton.css").toExternalForm());

            alert.showAndWait().ifPresent(rs -> {
                if (rs.getButtonData() == ButtonBar.ButtonData.YES) {
                    dbUtils.remove(group);
                    initialize(null, null);
                }
            });
        }
    }

    @FXML
    public void back() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/DictionariesScreen.fxml"));
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
        groupsOfClientsRepository = this.context.getBean("groupsOfClientsRepository", GroupsOfClientsRepository.class);
        initialize(null, null);
    }

    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<GroupOfClient> groups = FXCollections.observableArrayList();

        if (dbUtils != null) {
            List<GroupOfClient> tmp_groups = groupsOfClientsRepository.getGroupsOfClients();
            Collections.sort(tmp_groups);
            groups.addAll(tmp_groups);
        }

        listViewGroupsOfClient.setItems(groups);
        listViewGroupsOfClient.refresh();
    }
}
