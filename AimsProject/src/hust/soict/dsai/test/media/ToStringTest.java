
package hust.soict.dsai.test.media;

import java.util.List;
import java.util.ArrayList;
import hust.soict.dsai.aims.media.*;

public class ToStringTest {

	public static void main(String[] args) {
        List<Media> collection = new ArrayList<Media>();

        Media dvd1 = new DigitalVideoDisc("The Lion King",
        "Animation", "Roger Allers", 87, 19.95f);
        collection.add(dvd1);

        Media cd1 = new CompactDisc("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);
        collection.add(cd1);

        Media book1 = new Book("Harry Poster", "JK Rowling", 18.99f);
        collection.add(book1);

        for (Media medium: collection) {
            System.out.println(medium);
        }
	}
}