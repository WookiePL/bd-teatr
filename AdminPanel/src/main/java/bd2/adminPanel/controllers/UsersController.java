package bd2.adminPanel.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import bd2.adminPanel.tmp.Right;
import bd2.adminPanel.tmp.User;
import bd2.adminPanel.tmp.UserRepository;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class UsersController implements Initializable {

    private static final UserRepository userRepository = new UserRepository();

    @FXML
    private StackPane usersStackPane;
    
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
    private Button buttonEditUser;

    @FXML
    private Button buttonDeleteUser;

    @FXML
    private CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5;

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

    @FXML
    public void backMenu() {
        FXMLLoader loader = new FXMLLoader(this.getClass()
                .getResource("/fxml/MainMenuScreen.fxml"));
        StackPane pane = null;

        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        usersStackPane.getChildren().clear();
        usersStackPane.getChildren().add(pane);
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

            buttonEditUser.setDisable(false);
            buttonDeleteUser.setDisable(false);

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
    public void addUser() {

        User user = new User(textFieldLogin.getText(),
                textFieldFirstName.getText(), textFieldLastName.getText(),
                textFieldEmail.getText(), textFieldPhone.getText(), null);

        List<Right> rights = new ArrayList<>();

        if (checkBox1.isSelected()) {
            rights.add(new Right(Right.RIGHT_1_ID, Right.RIGHT_1_ID,
                    Right.RIGHT_1_ID));
        }
        if (checkBox2.isSelected()) {
            rights.add(new Right(Right.RIGHT_2_ID, Right.RIGHT_2_ID,
                    Right.RIGHT_2_ID));
        }
        if (checkBox3.isSelected()) {
            rights.add(new Right(Right.RIGHT_3_ID, Right.RIGHT_3_ID,
                    Right.RIGHT_3_ID));
        }
        if (checkBox4.isSelected()) {
            rights.add(new Right(Right.RIGHT_4_ID, Right.RIGHT_4_ID,
                    Right.RIGHT_4_ID));
        }
        if (checkBox5.isSelected()) {
            rights.add(new Right(Right.RIGHT_5_ID, Right.RIGHT_5_ID,
                    Right.RIGHT_5_ID));
        }

        user.setRights(rights);

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

            user.setLogin(textFieldLogin.getText());
            user.setFirstName(textFieldFirstName.getText());
            user.setLastName(textFieldLastName.getText());
            user.setEmail(textFieldEmail.getText());
            user.setPhone(textFieldPhone.getText());

            List<Right> rights = new ArrayList<>();

            if (checkBox1.isSelected()) {
                rights.add(new Right(Right.RIGHT_1_ID, Right.RIGHT_1_ID,
                        Right.RIGHT_1_ID));
            }
            if (checkBox2.isSelected()) {
                rights.add(new Right(Right.RIGHT_2_ID, Right.RIGHT_2_ID,
                        Right.RIGHT_2_ID));
            }
            if (checkBox3.isSelected()) {
                rights.add(new Right(Right.RIGHT_3_ID, Right.RIGHT_3_ID,
                        Right.RIGHT_3_ID));
            }
            if (checkBox4.isSelected()) {
                rights.add(new Right(Right.RIGHT_4_ID, Right.RIGHT_4_ID,
                        Right.RIGHT_4_ID));
            }
            if (checkBox5.isSelected()) {
                rights.add(new Right(Right.RIGHT_5_ID, Right.RIGHT_5_ID,
                        Right.RIGHT_5_ID));
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

        buttonEditUser.setDisable(true);
        buttonDeleteUser.setDisable(true);

        listViewUsers.setItems(users);
        listViewUsers.refresh();
    }

}
