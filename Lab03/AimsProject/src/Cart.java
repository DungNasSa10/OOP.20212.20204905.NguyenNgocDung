
public class Cart {
	
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	
	
	public DigitalVideoDisc[] getItemOrdered() {
		return itemsOrdered;
	}
	
	public void setItemOrdered (DigitalVideoDisc[] dvds) {
		this.itemsOrdered = dvds;
	}

	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered == MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is almost full");
		} else {
			for (int i = 0; i < MAX_NUMBERS_ORDERED; i++) {
				if (!(itemsOrdered[i] instanceof DigitalVideoDisc)) {
					itemsOrdered[i] = disc;
					qtyOrdered++;
					System.out.println("Successfully added this dics");
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
				System.out.println("Successfully removed this disc");
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
	
	public String searchById(int id) {
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i].getId() == id) {
				return itemsOrdered[i].toString();
			}
		}
		return "No matching DVD is found";
	}
	
	public void print() {
		DigitalVideoDisc[] sortedCart = new DigitalVideoDisc[qtyOrdered];
		for (int i = 0; i < qtyOrdered; i++) {
			sortedCart[i] = itemsOrdered[i];
		}
		
		sortedCart = DVDUtils.sortByLength(sortedCart);
		sortedCart = DVDUtils.sortByCost(sortedCart);
		sortedCart = DVDUtils.sortByTitle(sortedCart);
		
		System.out.println("********************CART********************");
		System.out.println("Ordered Items:");
		
		for (int i = 0; i < qtyOrdered; i++) {
			System.out.println(i + 1 + ". DVD - " + sortedCart[i].toString());
		}
		
		System.out.println("Total cost: " + this.totalCost() + " $");
		System.out.println("********************************************");
	}
	
}


