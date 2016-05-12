package bd2.adminPanel.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import bd2.adminPanel.tmp.Right;
import bd2.adminPanel.tmp.User;
import bd2.adminPanel.tmp.UserRepository;
import java.awt.event.ActionEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Shadow;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class UsersController implements Initializable {

    private MainController mainController;

    private static UserRepository userRepository = new UserRepository();

    @FXML
    private ListView<User> listViewUsers;

    @FXML
    private ListView<Right> listViewRights;

    @FXML
    private TextField textFieldId;

    @FXML
    private TextField textFieldFirstName;

    @FXML
    private TextField textFieldLastName;

    @FXML
    private TextField textFieldEmail;

    @FXML
    private TextField textFieldPhone;
    
    @FXML
    private Button buttonAddUser;
    
    @FXML
    private Button buttonEditUser;
    
    @FXML
    private Button buttonEditRights;
    
    @FXML
    private Button buttonBackMenu;
    
    @FXML
    private Button buttonDeleteUser;
    
    private final DropShadow shadow = new DropShadow(BlurType.THREE_PASS_BOX, Color.rgb(0, 0, 0, 0.4), 5, 0.0, 0, 1);
    
    private String greenButtonReleasedStyle;
    
    private final String greenButtonPressedStyle = "-fx-background-color: linear-gradient(#a9ff00, #f0ff35), radial-gradient(center 50% +140%, radius 200%, #b8ee36 45%, #80c800 50%);";
    
    private final String greenButtonOnMouseStyle = "-fx-background-color: linear-gradient(#f4ff57, #caff38), radial-gradient(center 50% -40%, radius 200%, #ceff52 45%, #92e600 50%);";

    private static User selectedUser;

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public ListView<User> getListViewUsers() {
        return listViewUsers;
    }

    public ListView<Right> getListViewRights() {
        return listViewRights;
    }

    public User getSelectedUser() {
        return selectedUser;
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
    
    @FXML
    public void onMouseEntered() {
        buttonAddUser.setEffect(shadow);
        buttonAddUser.setStyle(greenButtonOnMouseStyle);
    }
    
    @FXML
    public void onMouseExited() {
        buttonAddUser.setEffect(null);
        buttonAddUser.setStyle(greenButtonReleasedStyle);
    }
    
    @FXML
    public void onMousePressed() {
        buttonAddUser.setStyle(greenButtonPressedStyle);
    }
    
    @FXML
    public void onMouseReleased() {
        buttonAddUser.setStyle(greenButtonReleasedStyle);
    }

    @FXML
    public void backMenu() {
        mainController.loadMenuScreen();
    }

    @FXML
    public void userDetail() {

        User user = listViewUsers.getSelectionModel().getSelectedItem();

        if (user == null) {
            return;
        }

        textFieldId.setText(user.getId());
        textFieldFirstName.setText(user.getFirstName());
        textFieldLastName.setText(user.getLastName());
        textFieldEmail.setText(user.getEmail());
        textFieldPhone.setText(user.getPhone());

        if (user.getRights() != null) {
            ObservableList<Right> rights = FXCollections.observableArrayList();
            rights.addAll(user.getRights());

            listViewRights.setItems(rights);
        } else {
            listViewRights.setItems(null);
        }
    }

    @FXML
    public void addUser() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/AddUserScreen.fxml"));
        Pane pane = null;

        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        AddUserController addUserController = loader.getController();
        addUserController.setMainController(mainController);

        mainController.setScreen(pane);
    }

    @FXML
    public void deleteUser() {
        User user = listViewUsers.getSelectionModel().getSelectedItem();
        userRepository.getUsers().remove(user);

        initialize(null, null);
    }

    @FXML
    public void editUser() {
        if (listViewUsers.getSelectionModel().getSelectedItem() == null) {
            return;
        }

        selectedUser = listViewUsers.getSelectionModel().getSelectedItem();

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/EditUserScreen.fxml"));
        Pane pane = null;

        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        EditUserController editUserController = loader.getController();
        editUserController.setMainController(mainController);

        mainController.setScreen(pane);
    }

    @FXML
    public void editRights() {
        if (listViewUsers.getSelectionModel().getSelectedItem() == null) {
            return;
        }

        selectedUser = listViewUsers.getSelectionModel().getSelectedItem();

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/EditRightsScreen.fxml"));
        Pane pane = null;

        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        EditRightsController editRightsController = loader.getController();
        editRightsController.setMainController(mainController);

        mainController.setScreen(pane);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<User> users = FXCollections.observableArrayList();
        users.addAll(userRepository.getUsers());

        greenButtonReleasedStyle = buttonAddUser.getStyle();
        
        listViewUsers.setItems(users);
    }

}
