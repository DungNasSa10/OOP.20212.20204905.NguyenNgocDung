package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
	
	public static void main(String[] args) {
		
		Store store = new Store();
		
		//test addDVD() method
		Media dvd1 = new DigitalVideoDisc("The Lion King",
				"Amimation", "Roger Allers", 87, 19.95f);
		Media dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction", "George Lucas", 87, 24.95f);
		Media dvd3 = new DigitalVideoDisc("Aladin", 
				"Amimation", 18.99f);
		Media dvd4 = new DigitalVideoDisc("End Game");
		
		
		//test addDVD()
		store.addMedia(dvd1);
		store.addMedia(dvd2, dvd3, dvd4);
		
		// test removeDVD()
		store.removeMedia(dvd1);
	}
	
}
