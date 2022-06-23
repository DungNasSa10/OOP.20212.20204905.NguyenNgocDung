package hust.soict.dsai.aims.screen.manager;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.screen.manager.app.AddBookToStoreApp;
import hust.soict.dsai.aims.screen.manager.app.AddCDToStoreApp;
import hust.soict.dsai.aims.screen.manager.app.AddDVDToStoreApp;
import hust.soict.dsai.aims.store.Store;

public class StoreManagerScreen extends JFrame {
	
	private Store store;
	
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");
		
		menu.add(new JMenuItem("View Store"));
		
		JMenu smUpdateStore = new JMenu("Update Store");
		
		JMenuItem addBookItem = new JMenuItem("Add Book");
		addBookItem.addActionListener(new AddBookListener());
		smUpdateStore.add(addBookItem);
		
		JMenuItem addCDItem = new JMenuItem("Add CD");
		addCDItem.addActionListener(new AddCDListener());
		smUpdateStore.add(addCDItem);
		
		JMenuItem addDVDItem = new JMenuItem("Add DVD");
		addDVDItem.addActionListener(new AddDVDListener());
		smUpdateStore.add(addDVDItem);

		menu.add(smUpdateStore);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
	}
	
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		
		return header;
	}
	
	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3, 3, 2, 2));
		
		List<Media> mediaInStore = store.getItemsInStore();
		for (int i = 0; i < 9; i++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i));
			center.add(cell);
		}
		
		return center;
	}
	
	private class AddBookListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			new AddBookToStoreApp(store);
			dispose();
		}
		
	}
	
	private class AddCDListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			new AddCDToStoreApp(store);
			dispose();
		}
		
	}
	
	public class AddDVDListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			new AddDVDToStoreApp(store);
			dispose();
		}
		
	}
	
	public StoreManagerScreen(Store store) {
		this.store = store;
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setTitle("Store");
		setSize(1024, 768);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		Store store = new Store();
		
		Media media1 = new DigitalVideoDisc("a1");
		Media media2 = new DigitalVideoDisc("a2");
		Media media3 = new DigitalVideoDisc("a3");
		Media media4 = new DigitalVideoDisc("a4");
		Media media5 = new DigitalVideoDisc("a5");
		Media media6 = new DigitalVideoDisc("a6");
		Media media7 = new DigitalVideoDisc("a7");
		Media media8 = new DigitalVideoDisc("a8");
		Media media9 = new DigitalVideoDisc("a9");
		
		store.addMedia(media1, media2, media3, media4, media5, media6, media7, media8, media9);
		
		new StoreManagerScreen(store);
	}
	
}



