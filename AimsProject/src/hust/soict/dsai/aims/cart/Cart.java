package hust.soict.dsai.aims.cart;

import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

import hust.soict.dsai.aims.exception.FullCartException;
import hust.soict.dsai.aims.exception.NonExistingMediaException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.utils.MediaUtils;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
	
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
	private DoubleProperty totalCostProperty = new SimpleDoubleProperty();
	
	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}
	
	public void addMedia(Media medium) throws FullCartException {
		if (itemsOrdered.size() == MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is full");
			throw new FullCartException("The cart is full");
		} else {
			itemsOrdered.add(medium);
			updateTotalCost();
			System.out.println("Successfully added " + medium.getTitle() + " to cart");
		}
	}
	
	public void addMedia(Media ... media) throws FullCartException {
		for (Media medium: media) {
			addMedia(medium);
		}
	}
	
	public void removeMedia(Media medium) throws NonExistingMediaException {
		if (itemsOrdered.contains(medium)) {
			itemsOrdered.remove(medium);
			updateTotalCost();
			System.out.println("Successfully removed " + medium.getTitle() + " from cart");
		} else {
			System.out.println("Remove failed! " +  medium.getTitle() + " isn't in cart");
			throw new NonExistingMediaException("Remove failed! " +  medium.getTitle() + " isn't in cart");
		}
	}
	
	public void removeMedia(Media ... media) throws NonExistingMediaException {
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
	
	public double totalCost(Media luckyItem) {
		float cost = 0f;
		
		for (Media medium: itemsOrdered) {
			cost += medium.getCost();
		}
		cost -= luckyItem.getCost();
		return Math.round(cost * 100.0f) / 100.0f;
	}
	
	public void updateTotalCost() {
		float totalCost = totalCost();
		totalCostProperty.set(totalCost);
	}
	
	public DoubleProperty getTotalCostProperty() {
		return totalCostProperty;
	}
	
	public void sortByCost() {
		MediaUtils.sortByCost(itemsOrdered);
	}
	
	public void sortByTitle() {
		MediaUtils.sortByTitle(itemsOrdered);
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
		//itemsOrdered = MediaUtils.sortByLength(itemsOrdered);
		MediaUtils.sortByTitle(itemsOrdered);
		
		System.out.println("********************CART********************");
		System.out.println("Ordered Items:");
		
		for (int i = 0; i < itemsOrdered.size(); i++) {
			System.out.println(i + 1 + ". DVD - " + itemsOrdered.get(i));
		}
		
		System.out.println("Total cost: " + this.totalCost() + " $");
		System.out.println("********************************************");
	}
	
	public void print(Media luckyItem) {
		MediaUtils.sortByTitle(itemsOrdered);
		
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
	
	public void empty() {
		itemsOrdered.clear();
		updateTotalCost();
	}
	
}


