package bd2.adminPanel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class AdminPanel extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("/fxml/LoginScreen.fxml"));

        StackPane stackPane = loader.load();

        Scene scene = new Scene(stackPane, 600, 408);

        primaryStage.setMinWidth(640);
        primaryStage.setMinHeight(472);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Admin Panel");
        primaryStage.show();
    }

}
