package hust.soict.dsai.aims.cart;
import java.util.ArrayList;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.utils.DVDUtils;

public class Cart {
	
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	
	
	public DigitalVideoDisc[] getItemOrdered() {
		return itemsOrdered;
	}

	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered == MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is almost full");
		} else {
			for (int i = 0; i < MAX_NUMBERS_ORDERED; i++) {
				if (!(itemsOrdered[i] != null)) {
					itemsOrdered[i] = disc;
					qtyOrdered++;
					System.out.println("Successfully added this dics to cart");
					break;
				}
			}
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
		for (DigitalVideoDisc dvd: dvdList) {
			this.addDigitalVideoDisc(dvd);
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		this.addDigitalVideoDisc(dvd1);
		this.addDigitalVideoDisc(dvd2);
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		int i = 0;
		
		while (i < MAX_NUMBERS_ORDERED) {
			if ((itemsOrdered[i] instanceof DigitalVideoDisc) && 
					(itemsOrdered[i].getTitle().equals(disc.getTitle()))) {
				itemsOrdered[i] = null;
				qtyOrdered--;
				System.out.println("Successfully removed this disc from cart");
				break;
			} else {
				i++;
			}
		}
		
		if (i == MAX_NUMBERS_ORDERED) {
			System.out.println("Remove failed! This disc isn't in cart");
		}
	}
	
	public float totalCost() {
		float cost = 0f;
		
		for (int i = 0; i < MAX_NUMBERS_ORDERED; i++) {
			if (itemsOrdered[i] instanceof DigitalVideoDisc) {
				cost += itemsOrdered[i].getCost();
			}
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
	
}


