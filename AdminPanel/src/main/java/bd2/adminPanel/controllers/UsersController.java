package bd2.adminPanel.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import bd2.adminPanel.dao.DBUtils;
import bd2.adminPanel.dao.RoleDAO;
import bd2.adminPanel.dao.UserDAO;
import bd2.adminPanel.dao.repository.RolesRepository;
import bd2.adminPanel.dao.repository.UsersRepository;
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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class UsersController implements Initializable {

    private AnnotationConfigApplicationContext context;
    private DBUtils dbUtils;
    private UsersRepository usersRepository;
    private RolesRepository rolesRepository;
    private List<CheckBox> listCheckBox;

    @FXML
    private StackPane usersStackPane;

    @FXML
    private ListView<UserDAO> listViewUsers;

    @FXML
    private TextField textFieldFirstName;

    @FXML
    private TextField textFieldLastName;

    @FXML
    private TextField textFieldEmail;

    @FXML
    private Button buttonEditUser;

    @FXML
    private Button buttonDeleteUser;

    @FXML
    private Label titleListCheckBox;

    @FXML
    private VBox boxListCheckBox;

    public ListView<UserDAO> getListViewUsers() {
        return listViewUsers;
    }

    @FXML
    public void backMenu() {
        if (context != null) {
            context.close();
        }

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/MainMenuScreen.fxml"));
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

        UserDAO user = listViewUsers.getSelectionModel().getSelectedItem();

        if (user != null) {
            textFieldFirstName.setText(user.getName());
            textFieldLastName.setText(user.getSurname());
            textFieldEmail.setText(user.getEmail());

            buttonEditUser.setDisable(false);
            buttonDeleteUser.setDisable(false);

            if (user.getRoles() != null) {
                ObservableList<RoleDAO> roles = FXCollections.observableArrayList();
                roles.addAll(user.getRoles());
            }

            List<RoleDAO> roles = user.getRoles();

            if (listCheckBox != null) {
                for (CheckBox checkBox : listCheckBox) {
                    checkBox.setSelected(false);
                    if (roles != null) {
                        for (RoleDAO role : roles) {
                            if (checkBox.getText().equals(role.getRole())) {
                                checkBox.setSelected(true);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    @FXML
    public void addUser() {
        UserDAO user = new UserDAO(textFieldFirstName.getText(), textFieldLastName.getText(), textFieldEmail.getText(), "tmpPassword");
        List<RoleDAO> roles = rolesRepository.getRoles();
        /*
        if (checkBox1.isSelected()) {
            user.getRoles().add(roles.get(0));
        }
        if (checkBox2.isSelected()) {
            user.getRoles().add(roles.get(1));
        }
        if (checkBox3.isSelected()) {
            user.getRoles().add(roles.get(2));
        }
        if (checkBox4.isSelected()) {
            user.getRoles().add(roles.get(3));
        }
        if (checkBox5.isSelected()) {
            user.getRoles().add(roles.get(4));
        }
         */
        dbUtils.persist(user);

        initialize(null, null);
    }

    @FXML
    public void deleteUser() {
        UserDAO user = listViewUsers.getSelectionModel().getSelectedItem();

        if (user != null) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.getButtonTypes().set(0, new ButtonType("Tak", ButtonBar.ButtonData.YES));
            alert.getButtonTypes().set(1, new ButtonType("Nie", ButtonBar.ButtonData.NO));
            alert.setTitle("Usun¹æ?");
            alert.setHeaderText("Czy na pewno chcesz usun¹æ poni¿szego " + "u¿ytkownika?");
            alert.setContentText("Imiê i nazwisko: " + user.getName() + " " + user.getSurname());

            alert.showAndWait().ifPresent(rs -> {
                if (rs.getButtonData() == ButtonBar.ButtonData.YES) {
                    dbUtils.remove(user);
                    initialize(null, null);
                }
            });
        }
    }

    @FXML
    public void editUser() {
        UserDAO user = listViewUsers.getSelectionModel().getSelectedItem();
        if (user != null) {
            user.setName(textFieldFirstName.getText());
            user.setSurname(textFieldLastName.getText());
            user.setEmail(textFieldEmail.getText());

            List<RoleDAO> roles = rolesRepository.getRoles();
            /*
            if (checkBox1.isSelected()) {
                if (!user.getRoles().contains(roles.get(0))) {
                    user.getRoles().add(roles.get(0));
                }
            } else if (user.getRoles().contains(roles.get(0))) {
                user.getRoles().remove(roles.get(0));
            }
            if (checkBox2.isSelected()) {
                if (!user.getRoles().contains(roles.get(1))) {
                    user.getRoles().add(roles.get(1));
                }
            } else if (user.getRoles().contains(roles.get(1))) {
                user.getRoles().remove(roles.get(1));
            }
            if (checkBox3.isSelected()) {
                if (!user.getRoles().contains(roles.get(2))) {
                    user.getRoles().add(roles.get(2));
                }
            } else if (user.getRoles().contains(roles.get(2))) {
                user.getRoles().remove(roles.get(2));
            }
            if (checkBox4.isSelected()) {
                if (!user.getRoles().contains(roles.get(3))) {
                    user.getRoles().add(roles.get(3));
                }
            } else if (user.getRoles().contains(roles.get(3))) {
                user.getRoles().remove(roles.get(3));
            }
            if (checkBox5.isSelected()) {
                if (!user.getRoles().contains(roles.get(4))) {
                    user.getRoles().add(roles.get(4));
                }
            } else if (user.getRoles().contains(roles.get(4))) {
                user.getRoles().remove(roles.get(4));
            }
             */
            dbUtils.persist(user);

            initialize(null, null);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<UserDAO> users = FXCollections.observableArrayList();
        List<RoleDAO> roles = null;

        if (dbUtils != null) {
            List<UserDAO> tmp_users = usersRepository.getUsers();
            users.addAll(tmp_users);
            roles = rolesRepository.getRoles();
        }

        buttonEditUser.setDisable(true);
        buttonDeleteUser.setDisable(true);

        listViewUsers.setItems(users);
        listViewUsers.refresh();

        if (roles == null || roles.isEmpty()) {
            titleListCheckBox.setVisible(false);
        } else {
            listCheckBox.clear();
            for (RoleDAO role : roles) {
                listCheckBox.add(new CheckBox(role.getRole()));
            }
            for (CheckBox checkBox : listCheckBox) {
                boxListCheckBox.getChildren().add(checkBox);
            }
        }
    }

    public void setContextAndRepositories(AnnotationConfigApplicationContext context, DBUtils dbUtils,
            UsersRepository usersRepository, RolesRepository rolesRepository) {

        setContext(context);
        setDBUtils(dbUtils);
        setUsersRepository(usersRepository);
        setRolesRepository(rolesRepository);

        initialize(null, null);
    }

    private void setContext(AnnotationConfigApplicationContext context) {
        this.context = context;
    }

    private void setDBUtils(DBUtils dbUtils) {
        this.dbUtils = dbUtils;
    }

    private void setUsersRepository(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    private void setRolesRepository(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }
}
