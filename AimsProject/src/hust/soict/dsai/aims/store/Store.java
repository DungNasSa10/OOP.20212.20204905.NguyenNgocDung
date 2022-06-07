package hust.soict.dsai.aims.store;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.media.Media;


public class Store {
	
	private List<Media> itemsInStore = new ArrayList<Media>();
	//private static final int DEFAULT_STORE_LENGTH = 20;
	
	public Store() {
		super();
		//this.itemsInStore = new DigitalVideoDisc[DEFAULT_STORE_LENGTH];
	}
	
	public Store(List<Media> media) {
		this();
		itemsInStore = media;
	}
	
	public void addMedia(Media medium) {
		itemsInStore.add(medium);
		System.out.println("Successfully added " + medium.getTitle() + " to the store");
	}
	
	public void addMedia(Media ... media) {
		for (Media medium: media) {
			addMedia(medium);
		}
	}
	
	public void removeMedia(Media medium) {
		if (itemsInStore.contains(medium)) {
			itemsInStore.remove(medium);
			System.out.println("Sucessfully removed " + medium.getTitle() + " from the store");
		} else {
			System.out.println("Remove failed! " +  medium.getTitle() + " isn't in cart");
		}
	}
	
	public void removeMedia(Media ... media) {
		for (Media medium: media) {
			removeMedia(medium);
		}
	}
	
	public List<Media> searchByTitle(String title) {
		List<Media> matchingMedia = new ArrayList<Media>();
		
		for (Media medium: itemsInStore) {
			if (medium.getTitle().equals(title)) {
				matchingMedia.add(medium);
			}
		}
		
		if (matchingMedia.size() != 0) {
			System.out.println("Successfully found medium with title " + title + " in store");
		} else {
			System.out.println("No matching medium with title " + title + " is found in store");
		}
		return matchingMedia;
	}
	
	public Media searchById(int id) {
		for (Media medium: itemsInStore) {
			if (medium.getId() == id) {
				System.out.println("Successfully found medium with id " + id + " in store");
				return medium;
			}
		}
		
		System.out.println("No matching medium with id " + id + " is found in store");
		return null;
	}
	
	public void displayMedia() {
		for (Media medium: itemsInStore) {
			System.out.println(medium);
		}
	}

	public List<Media> getItemsInStore() {
		return itemsInStore;
	}
	
}
