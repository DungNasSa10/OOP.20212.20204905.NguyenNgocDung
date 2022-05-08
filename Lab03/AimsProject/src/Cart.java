
public class Cart {
	
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;

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
}
