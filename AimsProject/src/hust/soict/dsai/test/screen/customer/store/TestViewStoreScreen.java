package hust.soict.dsai.test.screen.customer.store;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.screen.customer.controller.ViewStoreController;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.cart.Cart;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application {
	
	private static Store store;
	private static Cart cart;

	@Override
	public void start(Stage primaryStage) throws Exception {
		final String STORE_FXML_FILE_PATH = "/hust/soict/dsai/aims/screen/customer/view/Store.fxml";
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
		ViewStoreController viewStoreController = new ViewStoreController(store, cart);
		fxmlLoader.setController(viewStoreController);
		Parent root = fxmlLoader.load();
		
		primaryStage.setTitle("Store");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		store = new Store();
		cart = new Cart();
		
		Media media1 = new DigitalVideoDisc("a1", "a", "b", 10, 20);
		Media media2 = new Book("a2", "a", 10);
		Media media3 = new CompactDisc("a3");
		Media media4 = new Book("a4");
		Media media5 = new DigitalVideoDisc("a5");
		Media media6 = new Book("a6");
		Media media7 = new CompactDisc("a7");
		Media media8 = new DigitalVideoDisc("a8");
		Media media9 = new DigitalVideoDisc("a9");
		
		store.addMedia(media1, media2, media3, media4, media5, media6, media7, media8, media9);
		
		launch(args);

	}

}
