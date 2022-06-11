package hust.soict.dsai.test.media;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;

public class MediaTest {
	public static void main(String[] args) {
		//Create a new cart
		Cart cart = new Cart();
		
		//Create new dvd objects and add them to the cart
		Media dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation", "Roger Allers", 87, 19.95f);
		cart.addMedia(dvd1);
		
		Media dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction", "George Lucas", 87, 24.95f);
		cart.addMedia(dvd2);
		
		Media dvd3 = new DigitalVideoDisc("Aladin", 
				"Animation", 18.99f);
		cart.addMedia(dvd3);
		System.out.println(dvd3 instanceof Media);

		Track track1 = new Track("title", 10);
		Track track2 = new Track("title", 0);
		System.out.println("Track compared result: " + track1.equals(track2));
		
		// test isMatch()
		System.out.println(dvd1.isMatch("The Lion King"));
		System.out.println(dvd2.isMatch("Avengers: End Game"));
		
		// test searchByTitle()
		cart.searchByTitle("The Lion King");
		cart.searchByTitle("Avengers: End Game");
	}
}
