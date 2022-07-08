package hust.soict.dsai.aims.screen.manager.app;

import javax.swing.JFrame;

import hust.soict.dsai.aims.screen.manager.controller.AddDVDToStoreController;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class AddDVDToStoreApp extends AddItemToStoreApp {

	public AddDVDToStoreApp(Store store) {
		super(store);
		
		JFrame frame = this;
		
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		this.setTitle("Add DVD to store");
		this.setVisible(true);
		Platform.runLater(new Runnable() {

			@Override
			public void run() {

				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/dsai/aims/screen/manager/view/AddDVDToStoreScreen.fxml"));
					AddDVDToStoreController controller = new AddDVDToStoreController(store, frame);
					loader.setController(controller);
					Parent root = loader.load();
					fxPanel.setScene(new Scene(root));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
	}

}
