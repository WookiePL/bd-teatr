package bd2.adminPanel.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import bd2.adminPanel.tmp.Right;
import bd2.adminPanel.tmp.User;
import bd2.adminPanel.tmp.UserRepository;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
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
    private TextField textFieldLogin;

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
    private Button buttonBackMenu;

    @FXML
    private Button buttonDeleteUser;

    @FXML
    private CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5;

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

    private final String redButtonReleasedStyle = "-fx-background-color: "
            + "linear-gradient(#ff3535, #ff0000), radial-gradient(center 50% "
            + "-40%, radius 200%, #ee3636 45%, #c80000 50%); -fx-background-"
            + "radius: 6, 5; -fx-background-insets: 0, 1; -fx-text-fill: "
            + "#ffe3e3";

    private final String redButtonPressedStyle = "-fx-background-color: "
            + "linear-gradient(#ff0000, #ff3535), radial-gradient(center 50% "
            + "+140%, radius 200%, #ee3636 45%, #c80000 50%); -fx-background-"
            + "radius: 6, 5; -fx-background-insets: 0, 1; -fx-text-fill: "
            + "#ffe3e3";

    private final String redButtonOnMouseStyle = "-fx-background-color: "
            + "linear-gradient(#ff7373, #ffa6a6), radial-gradient(center 50% "
            + "-40%, radius 200%, #ff6b6b 45%, #f00000 50%); -fx-background-"
            + "radius: 6, 5; -fx-background-insets: 0, 1; -fx-text-fill: "
            + "#ffe3e3";

    private static User selectedUser;

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public ListView<User> getListViewUsers() {
        return listViewUsers;
    }

    public User getSelectedUser() {
        return selectedUser;
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
    public void buttonAddUserOnMouseEntered() {
        buttonAddUser.setEffect(shadow);
        buttonAddUser.setStyle(greenButtonOnMouseStyle);
    }

    @FXML
    public void buttonAddUserOnMouseExited() {
        buttonAddUser.setEffect(null);
        buttonAddUser.setStyle(greenButtonReleasedStyle);
    }

    @FXML
    public void buttonAddUserOnMousePressed() {
        buttonAddUser.setStyle(greenButtonPressedStyle);
    }

    @FXML
    public void buttonAddUserOnMouseReleased() {
        buttonAddUser.setStyle(greenButtonReleasedStyle);
    }

    @FXML
    public void buttonEditUserOnMouseEntered() {
        buttonEditUser.setEffect(shadow);
        buttonEditUser.setStyle(greenButtonOnMouseStyle);
    }

    @FXML
    public void buttonEditUserOnMouseExited() {
        buttonEditUser.setEffect(null);
        buttonEditUser.setStyle(greenButtonReleasedStyle);
    }

    @FXML
    public void buttonEditUserOnMousePressed() {
        buttonEditUser.setStyle(greenButtonPressedStyle);
    }

    @FXML
    public void buttonEditUserOnMouseReleased() {
        buttonEditUser.setStyle(greenButtonReleasedStyle);
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
    public void buttonDeleteUserOnMouseEntered() {
        buttonDeleteUser.setEffect(shadow);
        buttonDeleteUser.setStyle(redButtonOnMouseStyle);
    }

    @FXML
    public void buttonDeleteUserOnMouseExited() {
        buttonDeleteUser.setEffect(null);
        buttonDeleteUser.setStyle(redButtonReleasedStyle);
    }

    @FXML
    public void buttonDeleteUserOnMousePressed() {
        buttonDeleteUser.setStyle(redButtonPressedStyle);
    }

    @FXML
    public void buttonDeleteUserOnMouseReleased() {
        buttonDeleteUser.setStyle(redButtonReleasedStyle);
    }

    @FXML
    public void backMenu() {
        mainController.loadMenuScreen();
    }

    @FXML
    public void userDetail() {

        User user = listViewUsers.getSelectionModel().getSelectedItem();

        if (user != null) {
            textFieldLogin.setText(user.getLogin());
            textFieldFirstName.setText(user.getFirstName());
            textFieldLastName.setText(user.getLastName());
            textFieldEmail.setText(user.getEmail());
            textFieldPhone.setText(user.getPhone());

            buttonEditUser.setVisible(true);
            buttonDeleteUser.setVisible(true);

            if (user.getRights() != null) {
                ObservableList<Right> rights
                        = FXCollections.observableArrayList();
                rights.addAll(user.getRights());
            }
            
            checkBox1.setSelected(false);
            checkBox2.setSelected(false);
            checkBox3.setSelected(false);
            checkBox4.setSelected(false);
            checkBox5.setSelected(false);
            
            List<Right> rights = user.getRights();

            if (rights != null) {
                for (Right right : rights) {
                    switch (right.getId()) {
                        case "1":
                            checkBox1.setSelected(true);
                            break;
                        case "2":
                            checkBox2.setSelected(true);
                            break;
                        case "3":
                            checkBox3.setSelected(true);
                            break;
                        case "4":
                            checkBox4.setSelected(true);
                            break;
                        case "5":
                            checkBox5.setSelected(true);
                            break;
                        default:
                            break;
                    }
                }
            }
        }
    }

    @FXML
    public void addUser() {/*
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/AddUserScreen.fxml"));
        Pane pane = null;

        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        AddUserController addUserController = loader.getController();
        addUserController.setMainController(mainController);

        mainController.setScreen(pane);*/ // MO¯NA WYWALIÆ OKNO DODAWANIA USERA I KLASÊ KONTROLERA ZA NIE ODPOWIEDZIALN¥.

        User user = new User(textFieldLogin.getText(),
                textFieldFirstName.getText(), textFieldLastName.getText(),
                textFieldEmail.getText(), textFieldPhone.getText(), null);

        userRepository.getUsers().add(user);
        initialize(null, null);
    }

    @FXML
    public void deleteUser() {
        User user = listViewUsers.getSelectionModel().getSelectedItem();

        if (user != null) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.getButtonTypes().set(0, new ButtonType("Tak",
                    ButtonBar.ButtonData.YES));
            alert.getButtonTypes().set(1, new ButtonType("Nie",
                    ButtonBar.ButtonData.NO));
            alert.setTitle("Usun¹æ?");
            alert.setHeaderText("Czy na pewno chcesz usun¹æ poni¿szego "
                    + "u¿ytkownika?");
            alert.setContentText("Login: " + user.getLogin() + ", "
                    + "Imiê i nazwisko: " + user.getFirstName() + " "
                    + user.getLastName());

            alert.showAndWait().ifPresent(rs -> {
                if (rs.getButtonData() == ButtonBar.ButtonData.YES) {
                    userRepository.getUsers().remove(user);
                    initialize(null, null);
                }
            });
        }
    }

    @FXML
    public void editUser() {
        User user = listViewUsers.getSelectionModel().getSelectedItem();
        if (user != null) {
            selectedUser = user;
            /*
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
             */ // MO¯NA WYWALIÆ OKNO EDYTOWANIA USERA I KLASÊ KONTROLERA ZA NIE ODPOWIEDZIALN¥.

            user.setLogin(textFieldLogin.getText());
            user.setFirstName(textFieldFirstName.getText());
            user.setLastName(textFieldLastName.getText());
            user.setEmail(textFieldEmail.getText());
            user.setPhone(textFieldPhone.getText());
            
            List<Right> rights = new ArrayList<>();

            if (checkBox1.isSelected()) {
                rights.add(new Right(Right.RIGHT_1_ID, Right.RIGHT_1_ID, Right.RIGHT_1_ID));
            } 
            if (checkBox2.isSelected()) {
                rights.add(new Right(Right.RIGHT_2_ID, Right.RIGHT_2_ID, Right.RIGHT_2_ID));
            } 
            if (checkBox3.isSelected()) {
                rights.add(new Right(Right.RIGHT_3_ID, Right.RIGHT_3_ID, Right.RIGHT_3_ID));
            }
            if (checkBox4.isSelected()) {
                rights.add(new Right(Right.RIGHT_4_ID, Right.RIGHT_4_ID, Right.RIGHT_4_ID));
            }
            if (checkBox5.isSelected()) {
                rights.add(new Right(Right.RIGHT_5_ID, Right.RIGHT_5_ID, Right.RIGHT_5_ID));
            }

            user.setRights(rights);
            
            for (int index = 0; index < userRepository.getUsers().size();
                    ++index) {
                if (userRepository.getUsers().get(index).getLogin().
                        equals(selectedUser.getLogin())) {
                    userRepository.getUsers().set(index, user);
                }
            }

            initialize(null, null);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<User> users = FXCollections.observableArrayList();
        users.addAll(userRepository.getUsers());

        buttonEditUser.setVisible(false);
        buttonDeleteUser.setVisible(false);

        listViewUsers.setItems(users);
        listViewUsers.refresh();
    }

}
