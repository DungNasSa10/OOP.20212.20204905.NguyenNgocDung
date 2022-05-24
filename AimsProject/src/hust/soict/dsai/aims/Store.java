package hust.soict.dsai.aims;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import java.util.ArrayList;


public class Store {
	
	private DigitalVideoDisc[] itemsInStore;
	//private static final int DEFAULT_STORE_LENGTH = 20;
	
	public Store() {
		super();
		//this.itemsInStore = new DigitalVideoDisc[DEFAULT_STORE_LENGTH];
	}
	
	public Store(DigitalVideoDisc[] dvds) {
		this();
		this.itemsInStore = dvds;
	}
	
	public void addDVD(DigitalVideoDisc disc) {
		ArrayList<DigitalVideoDisc> items = new ArrayList<DigitalVideoDisc>();
		
		if (itemsInStore != null) {
			for (DigitalVideoDisc dvd: itemsInStore) {
				items.add(dvd);
			}
		}

		items.add(disc);
		itemsInStore = items.toArray(new DigitalVideoDisc[items.size()]);
		System.out.println("Successfully added this disc to store");
	}
	
	public void addDVD(DigitalVideoDisc ... dvds) {
		for (DigitalVideoDisc dvd: dvds) {
			this.addDVD(dvd);
		}
	}
	
	public void removeDVD(DigitalVideoDisc disc) {
		int i = 0;
		int length = itemsInStore.length;
		
		while (i < length) {
			if ((itemsInStore[i] != null) && 
					(itemsInStore[i].getTitle().equals(disc.getTitle()))) {
				itemsInStore[i] = null;
				System.out.println("Successfully removed this disc from store");
				break;
			} else {
				i++;
			}
		}
		
		if (i == length) {
			System.out.println("Remove failed! This disc isn't in store");
		}
	}
	
	public void removeDVD(DigitalVideoDisc ... dvds) {
		for (DigitalVideoDisc dvd: dvds) {
			this.removeDVD(dvd);
		}
	}
	
	public ArrayList<DigitalVideoDisc> searchByTitle(String title) {
		ArrayList<DigitalVideoDisc> matchingDVD = new ArrayList<DigitalVideoDisc>();
		
		for (int i = 0; i < itemsInStore.length; i++) {
			if (itemsInStore[i] != null && itemsInStore[i].getTitle().equals(title)) {
				//System.out.println("Successfully found dvd with this title");
				matchingDVD.add(itemsInStore[i]);
			}
		}
		if (matchingDVD.size() != 0) {
			System.out.println("Successfully found DVD with this title in store");
		} else {
			System.out.println("No matching DVD with this title is found in store");
		}
		return matchingDVD;
	}
	
	public DigitalVideoDisc searchById(int id) {
		for (int i = 0; i < itemsInStore.length; i++) {
			if (itemsInStore[i] != null && itemsInStore[i].getId() == id) {
				System.out.println("Successfully found DVD with this id in store");
				return itemsInStore[i];
			}
		}
		System.out.println("No matching DVD with this id is found in store");
		return null;
	}
	
	public void displayDVDs() {
		for (int i = 0; i < itemsInStore.length; i++) {
			if (itemsInStore[i] != null) {
				System.out.println(itemsInStore[i]);
			}
		}
	}
	
}
