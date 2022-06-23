package hust.soict.dsai.aims.screen.manager.controller;

import javax.swing.JFrame;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class AddDVDToStoreController extends AddItemToStoreController {

	private String director;
	private int length;
	private Media dvd;
	
	@FXML
	private TextField tfDirector;
	
	@FXML
	private TextField tfLength;

	public AddDVDToStoreController(Store store, JFrame stage) {
		super(store, stage);
	}

	@FXML
	protected void addBtnPressed() {
		dvd = new DigitalVideoDisc(this.title, this.category, this.director, this.length, this.cost);
		store.addMedia(dvd);
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Notification");
		alert.setHeaderText("Success");
		alert.setContentText("Successfully added " + dvd.getTitle() + " to the store");
		alert.showAndWait();
	}
	
	public void initialize() {
		tfDirector.textProperty().addListener((observable, oldValue, newValue) -> director = newValue);
		tfLength.textProperty().addListener((observable, oldValue, newValue) -> {
				try {
					int number = Integer.parseInt(newValue);
					length = number;
				} catch (NumberFormatException e) {
					length = 0;
				}
		});
		super.initialize();
	}
	
}
