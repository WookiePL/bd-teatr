package bd2.adminPanel.controllers;

import java.io.IOException;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

public class LoginController {

    @FXML
    private StackPane loginStackPane;

    @FXML
    private TextField textFieldLogin;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label labelWrongLogin;

    @FXML
    private Label labelWrongPassword;

    @FXML
    public void login() {
        String login = "admin";
        String password = "admin";

        loadMainScreen();
        /*
		if(login.equals(textFieldLogin.getText())) {
                    if(password.equals(passwordField.getText())) {
			loadMainScreen();
                    }
                    else {
                        labelWrongLogin.setVisible(false);
                        labelWrongPassword.setVisible(true);
                    }
		} else {
                        labelWrongPassword.setVisible(false);
			labelWrongLogin.setVisible(true);
		}*/
    }

    @FXML
    public void exit() {
        Platform.exit();
    }

    private void loadMainScreen() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/MainScreen.fxml"));
        StackPane pane = null;

        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        loginStackPane.getChildren().clear();
        loginStackPane.getChildren().add(pane);
    }
}
