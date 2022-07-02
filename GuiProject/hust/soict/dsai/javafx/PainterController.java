package hust.soict.dsai.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {
	
	private boolean isPaint = true;
	
    @FXML
    private ToggleGroup identical;

    @FXML
    private BorderPane drawingAreaPane;

    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }
    
    @FXML
    void eraserSelected(ActionEvent event) {
    	isPaint = false;
    }

    @FXML
    void penSelected(ActionEvent event) {
    	isPaint = true;
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	if (isPaint) {
    		drawingAreaPane.getChildren().add( new Circle(event.getX(), event.getY(), 4, Color.BLACK));
    	} else {
    		drawingAreaPane.getChildren().add(new Circle(event.getX(), event.getY(), 6, Color.WHITE));
    	}
    }
    
}
