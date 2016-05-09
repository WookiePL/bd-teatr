package bd2.adminPanel.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import bd2.adminPanel.tmp.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class EditUserController implements Initializable {

	private MainController mainController;
	private FXMLLoader loader;
	private UsersController usersController;
	private Pane pane = null;

	@FXML
	private TextField textFieldFirstName;

	@FXML
	private TextField textFieldLastName;

	@FXML
	private TextField textFieldEmail;

	@FXML
	private TextField textFieldPhone;

	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}

	@FXML
	public void backToUsers() {
		init();
		mainController.setScreen(pane);
	}

	@FXML
	public void confirm() {
		init();

		List<User> users = usersController.getUserRepository().getUsers();
		for (int i = 0; i < users.size(); ++i) {
			if (users.get(i).getId().equals(usersController.getSelectedUser().getId())) {
				users.get(i).setFirstName(textFieldFirstName.getText());
				users.get(i).setLastName(textFieldLastName.getText());
				users.get(i).setEmail(textFieldEmail.getText());
				users.get(i).setPhone(textFieldPhone.getText());
			}
		}

		usersController.initialize(null, null);

		mainController.setScreen(pane);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		init();
		User user = usersController.getSelectedUser();
		textFieldFirstName.setText(user.getFirstName());
		textFieldLastName.setText(user.getLastName());
		textFieldEmail.setText(user.getEmail());
		textFieldPhone.setText(user.getPhone());
	}

	public void init() {
		loader = new FXMLLoader(this.getClass().getResource("/fxml/UsersScreen.fxml"));
		
		try {
			pane = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}

		usersController = loader.getController();
		usersController.setMainController(mainController);
	}
}
