package hust.soict.dsai.aims.screen.manager.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.swing.JFrame;

import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;

public class AddCDToStoreController extends AddItemToStoreController {
	
	private CompactDisc cd;
	private String artist;
	private String director;
	private List<Track> tracks = new ArrayList<Track>();
	
	@FXML
	private TextField tfArtist;
	
	@FXML
	private TextField tfDirector;
	
	@FXML
	private TextField tfTracks;

	public AddCDToStoreController(Store store, JFrame stage) {
		super(store, stage);
	}

	@FXML
	protected void addBtnPressed() {
		cd = new CompactDisc(title, category, director, artist, cost);
		
		for (Track track: tracks) {
			if (!cd.getTracks().contains(track)) {
				cd.addTrack(track);
			} else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Notification");
				alert.setHeaderText("Failure");
				alert.setContentText("The track " + track.getTitle() + " is already in the list of tracks");
				alert.showAndWait();
				tfTracks.setText("");
			}
		}
		store.addMedia(cd);
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Notification");
		alert.setHeaderText("Success");
		alert.setContentText("Successfully added " + cd.getTitle() + " to the store");
		alert.showAndWait();
	}
	
	@FXML
	private void addTrackBtnPressed() {
		Dialog<Pair<String, String>> dialog = new Dialog<>();
		dialog.setTitle("Input Dialog");
		dialog.setHeaderText("You can add new track here");

		dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 150, 10, 10));

		TextField trackTitle = new TextField();
		trackTitle.setPromptText("Enter track's name:");
		TextField trackLength = new TextField();
		trackLength.setPromptText("Enter track's length (integer):");

		grid.add(new Label("Title: "), 0, 0);
		grid.add(trackTitle, 1, 0);
		grid.add(new Label("Length: "), 0, 1);
		grid.add(trackLength, 1, 1);

		dialog.getDialogPane().setContent(grid);

		dialog.setResultConverter(dialogButton -> {
		    if (dialogButton == ButtonType.OK) {
		        return new Pair<>(trackTitle.getText(), trackLength.getText());
		    }
		    return null;
		});
		
		Optional<Pair<String, String>> result = dialog.showAndWait();
		
		if (result.isPresent()){
		    String title = result.get().getKey();
		    String lengthStr = result.get().getValue();
		    int length = 0;
		    try {
		    	length = Integer.parseInt(lengthStr);
		    } catch (NumberFormatException e) {
		    } finally {
		    	tracks.add(new Track(title, length));
		    	if (tfTracks.getText().length() == 0) {
		    		tfTracks.setText(title + ": " + length);
		    	} else {
		    		tfTracks.setText(tfTracks.getText() + ", " + title + ": " + length);
		    	}
		    }
		}
	}
	
	public void initialize() {
		tfDirector.textProperty().addListener((observable, oldValue, newValue) -> director = newValue);
		tfArtist.textProperty().addListener((observable, oldValue, newValue) -> artist = newValue);
		super.initialize();
	}

}
