package hust.soict.dsai.aims;

import java.util.ArrayList;

import hust.soict.dsai.aims.media.Media;


public class Store {
	
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	//private static final int DEFAULT_STORE_LENGTH = 20;
	
	public Store() {
		super();
		//this.itemsInStore = new DigitalVideoDisc[DEFAULT_STORE_LENGTH];
	}
	
	public Store(ArrayList<Media> medium) {
		this();
		itemsInStore = medium;
	}
	
	public void addMedia(Media media) {
		itemsInStore.add(media);
		System.out.println("Successfully added " + media.getTitle() + " to the store");
	}
	
	public void addMedia(Media ...medium) {
		for (Media media: medium) {
			addMedia(media);
		}
	}
	
	public void removeMedia(Media media) {
		if (itemsInStore.contains(media)) {
			itemsInStore.remove(media);
			System.out.println("Sucessfully removed " + media.getTitle() + " from store");
		} else {
			System.out.println("Remove failed! " +  media.getTitle() + " isn't in cart");
		}
	}
	
	public void removeMedia(Media ...medium) {
		for (Media media: medium) {
			removeMedia(media);
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
