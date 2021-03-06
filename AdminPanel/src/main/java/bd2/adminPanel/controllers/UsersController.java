package bd2.adminPanel.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import bd2.adminPanel.dao.DBUtils;
import bd2.adminPanel.dao.repository.RolesRepository;
import bd2.adminPanel.dao.repository.UsersRepository;
import bd2.adminPanel.model.users.Role;
import bd2.adminPanel.model.users.User;
import bd2.adminPanel.security.Security;

import java.util.ArrayList;
import java.util.Collections;
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
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class UsersController implements Initializable {

	private static final String EMAIL_EXIST = "Podany e-mail ju� istnieje";
	private static final String WRONG_LENGTH = "Minimalna d�ugo�� 3 znaki";
	
	private AnnotationConfigApplicationContext context;
	private DBUtils dbUtils;
	private UsersRepository usersRepository;
	private RolesRepository rolesRepository;
	private List<CheckBox> listCheckBox;
	private Security security;
	
	@FXML
	private StackPane usersStackPane;

	@FXML
	private ListView<User> listViewUsers;

	@FXML
	private TextField textFieldFirstName;

	@FXML
	private TextField textFieldLastName;

	@FXML
	private TextField textFieldEmail;

	@FXML
	private TextField textFieldPassword;

	@FXML
	private Label labelError;

	@FXML
	private Button buttonEditUser;

	@FXML
	private Button buttonDeleteUser;

	@FXML
	private Label titleListCheckBox;

	@FXML
	private VBox boxListCheckBox;

	public ListView<User> getListViewUsers() {
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

		User user = listViewUsers.getSelectionModel().getSelectedItem();

		if (user != null) {
			textFieldFirstName.setText(user.getName());
			textFieldLastName.setText(user.getSurname());
			textFieldEmail.setText(user.getEmail());
			textFieldPassword.setText(user.getPassword());

			buttonEditUser.setDisable(false);
			buttonDeleteUser.setDisable(false);

			if (user.getRoles() != null) {
				ObservableList<Role> roles = FXCollections.observableArrayList();
				roles.addAll(user.getRoles());
			}

			List<Role> roles = user.getRoles();

			if (listCheckBox != null) {
				for (CheckBox checkBox : listCheckBox) {
					checkBox.setSelected(false);
					if (roles != null) {
						for (Role role : roles) {
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
		String firstName = textFieldFirstName.getText();
		String lastName = textFieldLastName.getText();
		String email = textFieldEmail.getText();
		String password = textFieldPassword.getText();
		if (firstName.length() >= 3 && lastName.length() >= 3 && email.length() >= 3 && password.length() >= 3) {
			if(usersRepository.findUserByEmail(email) == null) {
				User user = new User(firstName, lastName, email, password);
				List<Role> roles = rolesRepository.getRoles();
	
				for (CheckBox checkBox : listCheckBox) {
					for (Role role : roles) {
						if (role.getRole().equals(checkBox.getText())) {
							if (checkBox.isSelected()) {
								user.getRoles().add(role);
							}
							break;
						}
					}
				}
				labelError.setVisible(false);
				dbUtils.persist(user);
				initialize(null, null);
			} else {
				labelError.setText(EMAIL_EXIST);
				labelError.setVisible(true);
			}
		} else {
			labelError.setText(WRONG_LENGTH);
			labelError.setVisible(true);
		}
	}

	@FXML
	public void deleteUser() {
		User user = listViewUsers.getSelectionModel().getSelectedItem();

		if (user != null) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.getButtonTypes().set(0, new ButtonType("Tak", ButtonBar.ButtonData.YES));
			alert.getButtonTypes().set(1, new ButtonType("Nie", ButtonBar.ButtonData.NO));
			alert.setTitle("Usun��?");
			alert.setHeaderText("Czy na pewno chcesz usun�� poni�szego " + "u�ytkownika?");
			alert.setContentText("E-mail: " + user.getEmail() + "\n" + "Imi� i nazwisko: " + user.getName() + " "
					+ user.getSurname());
			DialogPane dialogPane = alert.getDialogPane();
			dialogPane.getStylesheets().add(getClass().getResource("/fxml/GreenButton.css").toExternalForm());

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
		String firstName = textFieldFirstName.getText();
		String lastName = textFieldLastName.getText();
		String email = textFieldEmail.getText();
		String password = textFieldPassword.getText();
		User user = listViewUsers.getSelectionModel().getSelectedItem();
		if (user != null && firstName.length() >= 3 && lastName.length() >= 3 && email.length() >= 3 && password.length() >= 3) {
			if(!email.equals(user.getEmail()) && usersRepository.findUserByEmail(email) != null) {
				labelError.setText(EMAIL_EXIST);
				labelError.setVisible(true);
			} else {
				user.setName(firstName);
				user.setSurname(lastName);
				user.setEmail(email);
				user.setPassword(password);
	
				List<Role> roles = rolesRepository.getRoles();
	
				for (CheckBox checkBox : listCheckBox) {
					for (Role role : roles) {
						if (role.getRole().equals(checkBox.getText())) {
							if (checkBox.isSelected()) {
								if (!user.getRoles().contains(role)) {
									user.getRoles().add(role);
								}
							} else if (user.getRoles().contains(role)) {
								user.getRoles().remove(role);
							}
							break;
						}
					}
				}
				labelError.setVisible(false);
				dbUtils.persist(user);
				initialize(null, null);
			}
		} else {
			labelError.setText(WRONG_LENGTH);
			labelError.setVisible(true);
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<User> users = FXCollections.observableArrayList();
		List<Role> roles = null;

		if (dbUtils != null) {
			List<User> tmp_users = usersRepository.getUsers();
			users.addAll(tmp_users);
			roles = rolesRepository.getRoles();
		}

		buttonEditUser.setDisable(true);
		buttonDeleteUser.setDisable(true);

		Collections.sort(users);
		listViewUsers.setItems(users);
		listViewUsers.refresh();

		if (roles == null || roles.isEmpty()) {
			titleListCheckBox.setVisible(false);
		} else if (listCheckBox == null) {
			listCheckBox = new ArrayList<>();
			titleListCheckBox.setVisible(true);

			for (Role role : roles) {
				listCheckBox.add(new CheckBox(role.getRole()));
			}
			listCheckBox.stream().forEach((checkBox) -> {
				boxListCheckBox.getChildren().add(checkBox);
			});
		}
	}

	public void setContextAndRepositories(AnnotationConfigApplicationContext context) {
		dbUtils = context.getBean("DBUtils", DBUtils.class);
		usersRepository = context.getBean("usersRepository", UsersRepository.class);
		rolesRepository = context.getBean("rolesRepository", RolesRepository.class);
		security = context.getBean("security", Security.class);

		initialize(null, null);
	}
}
