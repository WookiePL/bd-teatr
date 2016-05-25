package bd2.adminPanel.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

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

    private final DropShadow shadow = new DropShadow(BlurType.THREE_PASS_BOX,
            Color.rgb(0, 0, 0, 0.4), 5, 0.0, 0, 1);

    private final String greenButtonReleasedStyle = "-fx-background-color: "
            + "linear-gradient(#f0ff35, #a9ff00), radial-gradient(center 50% "
            + "-40%, radius 200%, #b8ee36 45%, #80c800 50%); -fx-background-"
            + "radius: 6, 5; -fx-background-insets: 0, 1; -fx-text-fill: "
            + "#395306;";

    private final String greenButtonPressedStyle = "-fx-background-color: "
            + "linear-gradient(#a9ff00, #f0ff35), radial-gradient(center 50% "
            + "+140%, radius 200%, #b8ee36 45%, #80c800 50%); -fx-background-"
            + "radius: 6, 5; -fx-background-insets: 0, 1; -fx-text-fill: "
            + "#395306";

    private final String greenButtonOnMouseStyle = "-fx-background-color: "
            + "linear-gradient(#f4ff57, #caff38), radial-gradient(center 50% "
            + "-40%, radius 200%, #ceff52 45%, #92e600 50%); -fx-background-"
            + "radius: 6, 5; -fx-background-insets: 0, 1; -fx-text-fill: "
            + "#395306";

    @FXML
    public void buttonLoginOnMouseEntered() {
        buttonLogin.setEffect(shadow);
        buttonLogin.setStyle(greenButtonOnMouseStyle);
    }

    @FXML
    public void buttonLoginOnMouseExited() {
        buttonLogin.setEffect(null);
        buttonLogin.setStyle(greenButtonReleasedStyle);
    }

    @FXML
    public void buttonLoginOnMousePressed() {
        buttonLogin.setStyle(greenButtonPressedStyle);
    }

    @FXML
    public void buttonLoginOnMouseReleased() {
        buttonLogin.setStyle(greenButtonReleasedStyle);
    }

    @FXML
    public void buttonExitOnMouseEntered() {
        buttonExit.setEffect(shadow);
        buttonExit.setStyle(greenButtonOnMouseStyle);
    }

    @FXML
    public void buttonExitOnMouseExited() {
        buttonExit.setEffect(null);
        buttonExit.setStyle(greenButtonReleasedStyle);
    }

    @FXML
    public void buttonExitOnMousePressed() {
        buttonExit.setStyle(greenButtonPressedStyle);
    }

    @FXML
    public void buttonExitOnMouseReleased() {
        buttonExit.setStyle(greenButtonReleasedStyle);
    }

    @FXML
    public void login() {
        String login = "admin";
        String password = "admin";

        //loadMainScreen();
        
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
    }

    @FXML
    public void exit() {
        Platform.exit();
    }

    private void loadMainScreen() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/MainMenuScreen.fxml"));
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
