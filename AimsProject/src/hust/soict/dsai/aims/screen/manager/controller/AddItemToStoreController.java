package hust.soict.dsai.aims.screen.manager.controller;

import javax.swing.JFrame;

import hust.soict.dsai.aims.screen.manager.StoreManagerScreen;
import hust.soict.dsai.aims.screen.manager.app.AddBookToStoreApp;
import hust.soict.dsai.aims.screen.manager.app.AddCDToStoreApp;
import hust.soict.dsai.aims.screen.manager.app.AddDVDToStoreApp;
import hust.soict.dsai.aims.store.Store;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public abstract class AddItemToStoreController {
	
	private JFrame stage;
	protected Store store;
	protected String title;
	protected String category;
	protected float cost;
	
	@FXML
	protected TextField tfTitle;
	
	@FXML
	protected TextField tfCategory;
	
	@FXML
	protected TextField tfCost;

	public AddItemToStoreController(Store store, JFrame stage) {
		this.store = store;
		this.stage = stage;
	}
	
	@FXML
	protected void viewStoreMenu() {
		new StoreManagerScreen(store);
		stage.setVisible(false);
	}
	
	@FXML
	public void addBookMenu() {
		new AddBookToStoreApp(store);
		stage.setVisible(false);
	}
	
	@FXML
	public void addCDMenu() {
		new AddCDToStoreApp(store);
		stage.setVisible(false);
	}
	
	@FXML
	public void addDVDMenu() {
		new AddDVDToStoreApp(store);
		stage.setVisible(false);
	}
	
	public void initialize() {
		tfTitle.textProperty().addListener((observable, oldValue, newValue) -> title = newValue);
		tfCategory.textProperty().addListener((observable, oldValue, newValue) -> category = newValue);
		tfCost.textProperty().addListener((observable, oldValue, newValue) -> {
			try {
				cost = Float.parseFloat(newValue);
			} catch (Exception e) {
				cost = 0;
			}
		});
	}
	
	@FXML
	protected abstract void addBtnPressed();

}
