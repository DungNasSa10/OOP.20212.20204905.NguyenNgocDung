package hust.soict.dsai.aims.screen.manager.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.swing.JFrame;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;
import javafx.fxml.FXML;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class AddBookToStoreController extends AddItemToStoreController {
	
	private Book book;
	private List<String> authors = new ArrayList<String>();
	private int length;
	
	@FXML
	private TextField tfAuthors;
	
	@FXML
	private TextField tfLength;

	public AddBookToStoreController(Store store, JFrame stage) {
		super(store, stage);
	}

	@FXML
	protected void addBtnPressed() {
		book = new Book(this.title, this.category, this.length, this.cost);
		for (String author: authors) {
			if (!book.getAuthors().contains(author)) {
				book.addAuthor(author);
			} else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Notification");
				alert.setHeaderText("Failure");
				alert.setContentText(author +  " is already in list of authors");
				alert.showAndWait();
				tfAuthors.setText("");
				return;
			}
		}
		store.addMedia(book);
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Notification");
		alert.setHeaderText("Success");
		alert.setContentText("Successfully added " + book.getTitle() + " to the store");
		alert.showAndWait();
	}
	
	@FXML
	private void addAuthorBtnPressed() {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Text Input Dialog");
		dialog.setHeaderText("You can add new author");
		dialog.setContentText("Please enter author's name:");
		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()){
		    authors.add(result.get());
		    if (tfAuthors.getText().length() == 0) {
		    	tfAuthors.setText(result.get());
		    } else {
		    	tfAuthors.setText(tfAuthors.getText() + ", " + result.get());
		    }
		}
	}
	
	public void initialize() {
		tfLength.textProperty().addListener((observable, oldValue, newValue) -> {
			try {
				length = Integer.parseInt(newValue);
			} catch (Exception e) {
				length = 0;
			}
		});		
		super.initialize();
	}

}
