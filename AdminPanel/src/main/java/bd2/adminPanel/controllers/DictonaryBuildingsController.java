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
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class DictonaryBuildingsController {
    
    @FXML
    private StackPane dictionariesStackPane;
    
    @FXML
    private Button buttonBackMenu;
    
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
    public void buttonBackMenuOnMouseEntered() {
        buttonBackMenu.setEffect(shadow);
        buttonBackMenu.setStyle(greenButtonOnMouseStyle);
    }

    @FXML
    public void buttonBackMenuOnMouseExited() {
        buttonBackMenu.setEffect(null);
        buttonBackMenu.setStyle(greenButtonReleasedStyle);
    }

    @FXML
    public void buttonBackMenuOnMousePressed() {
        buttonBackMenu.setStyle(greenButtonPressedStyle);
    }

    @FXML
    public void buttonBackMenuOnMouseReleased() {
        buttonBackMenu.setStyle(greenButtonReleasedStyle);
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
