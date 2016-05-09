package bd2.adminPanel.controllers;

import java.io.IOException;

import bd2.adminPanel.tmp.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class AddUserController {

	private MainController mainController;
	private FXMLLoader loader;
	private UsersController usersController;
	private Pane pane = null;

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

	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}

	@FXML
	public void backToUsers() {
		init();
		mainController.setScreen(pane);
	}

	@FXML
	public void addUser() {
		init();
		
		User user = new User(textFieldId.getText(), textFieldFirstName.getText(), textFieldLastName.getText(),
				textFieldEmail.getText(), textFieldPhone.getText(), null);
		
		usersController.getUserRepository().getUsers().add(user);
		usersController.initialize(null, null);

		mainController.setScreen(pane);
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
