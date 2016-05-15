package bd2.adminPanel.controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.StackPane;

public class DictionariesController {

    @FXML
    private StackPane dictonariesStackPane;
    
    @FXML
    public void backMenu() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/MenuScreen.fxml"));
        StackPane pane = null;

        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        dictonariesStackPane.getChildren().clear();
        dictonariesStackPane.getChildren().add(pane);
    }
}
