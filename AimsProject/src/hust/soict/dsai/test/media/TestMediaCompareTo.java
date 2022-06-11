package hust.soict.dsai.test.media;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.utils.MediaUtils;

public class TestMediaCompareTo {

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

        // Iterate through the entries in the collection and output their title
        // unsorted order
        Iterator<Media> iterator = collection.iterator();

        System.out.println("------------------------------");
        System.out.println("The media curently in the order are: ");

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Sort the collection of Media - based on compareTo() method
        MediaUtils.sortByTitle(collection);

        // Iterate through the entries in the collection and output their title
        // in sorted order
        iterator = collection.iterator();

        System.out.println("------------------------------");
        System.out.println("The media in the sorted order are: ");

        while (iterator.hasNext()) {
            System.out.println(iterator.next().getTitle());
        }

        System.out.println("------------------------------");
    }

}