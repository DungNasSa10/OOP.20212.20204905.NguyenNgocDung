package hust.soict.dsai.aims.cart;

import java.util.ArrayList;
import java.lang.Math;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.utils.DVDUtils;

public class Cart {
	
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	
	public void addMedia(Media media) {
		if (itemsOrdered.size() == MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is full");
		} else {
			itemsOrdered.add(media);
			System.out.println("Successfully added " + media.getTitle() + " to cart");
		}
	}
	
	public void addMedia(Media ... medium) {
		for (Media media: medium) {
			addMedia(media);
		}
	}
	
	public void removeMedia(Media media) {
		if (itemsOrdered.contains(media)) {
			itemsOrdered.remove(media);
			System.out.println("Successfully removed " + media.getTitle() + " from cart");
		} else {
			System.out.println("Remove failed! " +  media.getTitle() + " isn't in cart");
		}
	}
	
	public void removeMedia(Media ... medium) {
		for (Media media: medium) {
			removeMedia(media);
		}
	}
	
	public float totalCost() {
		float cost = 0f;
		
		for (Media media: itemsOrdered) {
			cost += media.getCost();
		}
		
		return Math.round(cost * 100.0f) / 100.0f;
	}
	
	public void sortByCost() {
		this.itemsOrdered = DVDUtils.sortByCost(itemsOrdered);
	}
	
	public void sortByTitle() {
		itemsOrdered = DVDUtils.sortByTitle(itemsOrdered);
	}
	
	public DigitalVideoDisc searchById(int id) {
		for (int i = 0; i < MAX_NUMBERS_ORDERED; i++) {
			if (itemsOrdered[i] != null && itemsOrdered[i].getId() == id) {
				System.out.println("Succecssfully found DVD with this id in cart");
				return itemsOrdered[i];
			}
		}
		System.out.println("No matching DVD with this title is found in cart");
		return null;
	}
	
	public ArrayList<DigitalVideoDisc> searchByTitle(String title) {
		ArrayList<DigitalVideoDisc> matchingDVDs = new ArrayList<DigitalVideoDisc>();
		
		for (int i = 0; i < MAX_NUMBERS_ORDERED; i++) {
			if (itemsOrdered[i] != null && itemsOrdered[i].getTitle().equals(title)) {
				matchingDVDs.add(itemsOrdered[i]);
			}
		}
		if (matchingDVDs.size() != 0) {
			System.out.println("Successfully found DVD with this title in cart");
		} else {
			System.out.println("No matching DVD with this title is found in cart");
		}
		return matchingDVDs;
	}
	
	public void print() {
		ArrayList<DigitalVideoDisc> cart = new ArrayList<DigitalVideoDisc>();
		
		for (int i = 0; i < MAX_NUMBERS_ORDERED; i++) {
			if (itemsOrdered[i] != null) {
				cart.add(itemsOrdered[i]);
			}
		}
		
		DigitalVideoDisc[] sortedCart = cart.toArray(new DigitalVideoDisc[cart.size()]);
		
		sortedCart = DVDUtils.sortByLength(sortedCart);
		sortedCart = DVDUtils.sortByCost(sortedCart);
		sortedCart = DVDUtils.sortByTitle(sortedCart);
		
		System.out.println("********************CART********************");
		System.out.println("Ordered Items:");
		
		for (int i = 0; i < qtyOrdered; i++) {
			System.out.println(i + 1 + ". DVD - " + sortedCart[i]);
		}
		
		System.out.println("Total cost: " + this.totalCost() + " $");
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


