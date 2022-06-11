package hust.soict.dsai.aims.cart;

import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.utils.MediaUtils;

public class Cart {
	
	public static final int MAX_NUMBERS_ORDERED = 20;
	private List<Media> itemsOrdered = new ArrayList<Media>();
	
	public List<Media> getItemsOrdered() {
		return itemsOrdered;
	}
	
	public void addMedia(Media medium) {
		if (itemsOrdered.size() == MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is full");
		} else {
			if (itemsOrdered.contains(medium)) {
				System.out.println("The medium " + medium.getTitle() + " is already in cart");
			} else {
				itemsOrdered.add(medium);
				System.out.println("Successfully added " + medium.getTitle() + " to cart");
			}
		}
	}
	
	public void addMedia(Media ... media) {
		for (Media medium: media) {
			addMedia(medium);
		}
	}
	
	public void removeMedia(Media medium) {
		if (itemsOrdered.contains(medium)) {
			itemsOrdered.remove(medium);
			System.out.println("Successfully removed " + medium.getTitle() + " from cart");
		} else {
			System.out.println("Remove failed! " +  medium.getTitle() + " isn't in cart");
		}
	}
	
	public void removeMedia(Media ... media) {
		for (Media medium: media) {
			removeMedia(medium);
		}
	}
	
	public float totalCost() {
		float cost = 0f;
		
		for (Media medium: itemsOrdered) {
			cost += medium.getCost();
		}
		
		return Math.round(cost * 100.0f) / 100.0f;
	}
	
	public float totalCost(Media luckyItem) {
		float cost = 0f;
		
		for (Media medium: itemsOrdered) {
			cost += medium.getCost();
		}
		cost -= luckyItem.getCost();
		
		return Math.round(cost * 100.0f) / 100.0f;
	}
	
	public void sortByCost() {
		this.itemsOrdered = MediaUtils.sortByCost(itemsOrdered);
	}
	
	public void sortByTitle() {
		itemsOrdered = MediaUtils.sortByTitle(itemsOrdered);
	}
	
	public Media searchById(int id) {
		for (Media medium: itemsOrdered) {
			if (medium.getId() == id) {
				System.out.println("Succecssfully found medium with id " + id + " in cart");
				return medium;
			}
		}
		System.out.println("No matching medium with id " + id + " is found in cart");
		return null;
	}
	
	public List<Media> searchByTitle(String title) {
		List<Media> matchingMedia = new ArrayList<Media>();
		
		for (Media medium: itemsOrdered) {
			if (medium.getTitle().equals(title)) {
				matchingMedia.add(medium);
			}
		}
		
		if (matchingMedia.size() != 0) {
			System.out.println("Successfully found DVD with title " + title + " in cart");
		} else {
			System.out.println("No matching DVD with title " + title + " is found in cart");
		}
		return matchingMedia;
	}
	
	public void print() {
		itemsOrdered = MediaUtils.sortByLength(itemsOrdered);
		itemsOrdered = MediaUtils.sortByCost(itemsOrdered);
		itemsOrdered = MediaUtils.sortByTitle(itemsOrdered);
		
		System.out.println("********************CART********************");
		System.out.println("Ordered Items:");
		
		for (int i = 0; i < itemsOrdered.size(); i++) {
			System.out.println(i + 1 + ". DVD - " + itemsOrdered.get(i));
		}
		
		System.out.println("Total cost: " + this.totalCost() + " $");
		System.out.println("********************************************");
	}
	
	public void print(Media luckyItem) {
		itemsOrdered = MediaUtils.sortByLength(itemsOrdered);
		itemsOrdered = MediaUtils.sortByCost(itemsOrdered);
		itemsOrdered = MediaUtils.sortByTitle(itemsOrdered);
		
		System.out.println("********************CART********************");
		System.out.println("Ordered Items:");
		
		for (int i = 0; i < itemsOrdered.size(); i++) {
			System.out.println(i + 1 + ". DVD - " + itemsOrdered.get(i));
		}
		
		System.out.println("Total cost: " + this.totalCost(luckyItem) + " $");
		System.out.println("********************************************");
	}
	
	public Media getALuckyItem() {
		if (itemsOrdered.size() >= 5) {
			int minIndex = 0;
			int maxIndex = itemsOrdered.size() - 1;
			int range = maxIndex - minIndex + 1;
			int indexOfLuckyItem = (int)(Math.random() * range) + minIndex;
			Media luckyItem = itemsOrdered.get(indexOfLuckyItem);
			System.out.println("You have a lucky item: " + luckyItem.getTitle());
			return luckyItem;
		}
		return null;
	}
	
}


