package hust.soict.dsai.aims;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class StoreTest {
	
	public static void main(String[] args) {
		
		Store store = new Store();
		
		//test addDVD() method
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Amimation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", 
				"Amimation", 18.99f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("End Game");
		
		
		//test addDVD()
		store.addDVD(dvd1);
		store.addDVD(dvd2, dvd3, dvd4);
		
		// test removeDVD()
		store.removeDVD(dvd1);
	}
	
}
