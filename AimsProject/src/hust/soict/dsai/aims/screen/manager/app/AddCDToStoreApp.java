package hust.soict.dsai.aims.screen.manager.app;

import javax.swing.JFrame;

import hust.soict.dsai.aims.screen.manager.controller.AddCDToStoreController;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class AddCDToStoreApp extends AddItemToStoreApp {

	public AddCDToStoreApp(Store store) {
		super(store);
		
		JFrame frame = this;
		JFXPanel panel = new JFXPanel();
		this.add(panel);
		this.setTitle("Add CD To Store");
		this.setVisible(true);
		Platform.runLater(new Runnable() {
			
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/dsai/aims/screen/manager/view/AddCDToStoreScreen.fxml"));
					AddCDToStoreController addCDController = new AddCDToStoreController(store, frame);
					loader.setController(addCDController);
					Parent root = loader.load();
					panel.setScene(new Scene(root));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
