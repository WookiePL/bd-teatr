package bd2.adminPanel.controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class DictionariesController {

    @FXML
    private StackPane dictionariesStackPane;
    
    @FXML
    private Button buttonBackMenu;
    
    @FXML
    private Button buttonDayOfWeek;
    
    @FXML
    private Button buttonGroupOfClients;
    
    @FXML
    private Button buttonEventsType;
    
    @FXML
    private Button buttonBuildings;
    
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
    public void buttonDayOfWeekOnMouseEntered() {
        buttonDayOfWeek.setEffect(shadow);
        buttonDayOfWeek.setStyle(greenButtonOnMouseStyle);
    }

    @FXML
    public void buttonDayOfWeekOnMouseExited() {
        buttonDayOfWeek.setEffect(null);
        buttonDayOfWeek.setStyle(greenButtonReleasedStyle);
    }

    @FXML
    public void buttonDayOfWeekOnMousePressed() {
        buttonDayOfWeek.setStyle(greenButtonPressedStyle);
    }

    @FXML
    public void buttonDayOfWeekOnMouseReleased() {
        buttonDayOfWeek.setStyle(greenButtonReleasedStyle);
    }
    
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
    public void buttonGroupOfClientsOnMouseEntered() {
        buttonGroupOfClients.setEffect(shadow);
        buttonGroupOfClients.setStyle(greenButtonOnMouseStyle);
    }

    @FXML
    public void buttonGroupOfClientsOnMouseExited() {
        buttonGroupOfClients.setEffect(null);
        buttonGroupOfClients.setStyle(greenButtonReleasedStyle);
    }

    @FXML
    public void buttonGroupOfClientsOnMousePressed() {
        buttonGroupOfClients.setStyle(greenButtonPressedStyle);
    }

    @FXML
    public void buttonGroupOfClientsOnMouseReleased() {
        buttonGroupOfClients.setStyle(greenButtonReleasedStyle);
    }
    
    @FXML
    public void buttonEventsTypeOnMouseEntered() {
        buttonEventsType.setEffect(shadow);
        buttonEventsType.setStyle(greenButtonOnMouseStyle);
    }

    @FXML
    public void buttonEventsTypeOnMouseExited() {
        buttonEventsType.setEffect(null);
        buttonEventsType.setStyle(greenButtonReleasedStyle);
    }

    @FXML
    public void buttonEventsTypeOnMousePressed() {
        buttonEventsType.setStyle(greenButtonPressedStyle);
    }

    @FXML
    public void buttonEventsTypeOnMouseReleased() {
        buttonEventsType.setStyle(greenButtonReleasedStyle);
    }
    
    @FXML
    public void buttonBuildingsOnMouseEntered() {
        buttonBuildings.setEffect(shadow);
        buttonBuildings.setStyle(greenButtonOnMouseStyle);
    }

    @FXML
    public void buttonBuildingsOnMouseExited() {
        buttonBuildings.setEffect(null);
        buttonBuildings.setStyle(greenButtonReleasedStyle);
    }

    @FXML
    public void buttonBuildingsOnMousePressed() {
        buttonBuildings.setStyle(greenButtonPressedStyle);
    }

    @FXML
    public void buttonBuildingsOnMouseReleased() {
        buttonBuildings.setStyle(greenButtonReleasedStyle);
    }
    
    @FXML
    public void daysOfWeek() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(
                "/fxml/DictonaryDaysOfWeekScreen.fxml"));
        StackPane pane = null;

        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        dictionariesStackPane.getChildren().clear();
        dictionariesStackPane.getChildren().add(pane);
    }
    
    @FXML
    public void backMenu() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(
                "/fxml/MenuScreen.fxml"));
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
