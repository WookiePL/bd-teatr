package bd2.adminPanel.controllers;

import javafx.fxml.FXML;

public class UsersController {

	private MainController mainController;
	
	@FXML
	public void backMenu() {
		mainController.loadMenuScreen();
	}
	
	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}
}
