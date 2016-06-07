package bd2.adminPanel.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import bd2.adminPanel.config.SpringConfig;
import bd2.adminPanel.security.Security;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

public class LoginController implements Initializable {

    @FXML
    private StackPane loginStackPane;

    @FXML
    private TextField textFieldLogin;

    @FXML
    private PasswordField textPasswordField;

    @FXML
    private Label labelWrongLogin;

    @FXML
    private Label labelWrongPassword;

    @FXML
    private Button buttonLogin;

    @FXML
    private Button buttonExit;

    @FXML
    public void login() {
        String login = "admin";
        String password = "admin";

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        Security security = context.getBean("security", Security.class);
        
        if (!buttonExit.focusedProperty().get()) {
            if (login.equals(textFieldLogin.getText())) {
                if (password.equals(textPasswordField.getText())) {
                    loadMainScreen();
                } else {
                    labelWrongLogin.setVisible(false);
                    labelWrongPassword.setVisible(true);
                }
            } else {
                labelWrongPassword.setVisible(false);
                labelWrongLogin.setVisible(true);
            }
            
//          Z HASHOWANIEM
//        	if(security.authentication(textFieldLogin.getText(), textPasswordField.getText())) {
//        		context.close();
//        		loadMainScreen();
//        	} else {
//        		labelWrongPassword.setVisible(false);
//        		labelWrongLogin.setVisible(true);
//        	}        	
        } else {
            exit();
        }
    }

    @FXML
    public void exit() {
        Platform.exit();
    }

    private void loadMainScreen() {
        FXMLLoader loader = new FXMLLoader(this.getClass()
                .getResource("/fxml/MainMenuScreen.fxml"));
        StackPane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        loginStackPane.getChildren().clear();
        loginStackPane.getChildren().add(pane);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(() -> {
            textFieldLogin.requestFocus();
        });
    }
}
