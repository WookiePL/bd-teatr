package bd2.adminPanel.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import bd2.adminPanel.config.SpringConfig;
import bd2.adminPanel.dao.DBUtils;
import bd2.adminPanel.dao.repository.RolesRepository;
import bd2.adminPanel.dao.repository.UsersRepository;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class MainMenuController implements Initializable {

    private AnnotationConfigApplicationContext context;

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
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/UsersScreen.fxml"));
        StackPane pane = null;
        try {
            pane = loader.load();
            ((UsersController) loader.getController()).setContextAndRepositories(context/*, dbUtils, usersRepository, rolesRepository*/);
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
            ((DictionariesController) loader.getController()).setContext(context);
        } catch (IOException e) {
            e.printStackTrace();
        }

        menuStackPane.getChildren().clear();
        menuStackPane.getChildren().add(pane);
    }

    @FXML
    public void logout() {
        context.close();
        FXMLLoader loader = new FXMLLoader(this.getClass()
                .getResource("/fxml/LoginScreen.fxml"));
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
        context.close();
        Platform.exit();
        System.exit(0);
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

        context = new AnnotationConfigApplicationContext(SpringConfig.class);
    }
}
