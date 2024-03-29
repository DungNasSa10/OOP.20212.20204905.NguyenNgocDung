package hust.soict.dsai.aims.screen.manager.app;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import hust.soict.dsai.aims.screen.manager.StoreManagerScreen;
import hust.soict.dsai.aims.store.Store;

public abstract class AddItemToStoreApp extends JFrame {
	
	private Store store;
	
	public AddItemToStoreApp(Store store) {
		super();
		this.store = store;
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				new StoreManagerScreen(store);
				setVisible(false);
			}
		});
	}
	
}

	
	
	