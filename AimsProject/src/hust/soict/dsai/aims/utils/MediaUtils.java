package hust.soict.dsai.aims.utils;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.Disc;
import hust.soict.dsai.aims.media.Media;


public class MediaUtils {
	/**
	 * helper attributes used for sorting methods
	 */
	private static Comparator<Media> costComparator = new Comparator<Media>() {
		@Override
		public int compare(Media medium1, Media medium2) {
			return Float.compare(medium2.getCost(), medium1.getCost());
		}
	}; 
	
	private static Comparator<Media> titleComparator = new Comparator<Media>() {
		@Override
		public int compare(Media medium1, Media medium2) {
			return medium1.getTitle().compareTo(medium2.getTitle());
		}
	}; 
	
	private static Comparator<Media> lengthComparator = new Comparator<Media>() {
		@Override
		public int compare(Media medium1, Media medium2) {
			if (medium1 instanceof Book || medium2 instanceof Book) {
				return 0;
			} else {
				Disc disc1 = (Disc) medium1;
				Disc disc2 = (Disc) medium2;
				return Integer.compare(disc2.getLength(), disc1.getLength());
			}
		}
	};
	
	public static String compareByCost(Media medium1, Media medium2) {
		float comparedResult = medium1.getCost() - medium2.getCost();
		
		if (comparedResult < 0) {
			return "The first medium is cheaper than the second one";
		} else if (comparedResult == 0) {
			return "Two media have the same price";
		} else {
			return "The first medium is more expensive than the second one";
		}
	}
	
	public static String compareByTitle(Media medium1, Media medium2) {
		int comparedResult = medium1.getTitle().compareTo(medium2.getTitle());
		
		if (comparedResult < 0) {
			return "The first medium's title is smaller than that of the second one in alphabetical order";
		} else if (comparedResult == 0) {
			return "Two media have identical title";
		} else {
			return "The first medium's title is larger than that of the second one in alphabetical order";
		}
	}
	
	
	/**
	 * Sort an array of DigitalVideoDisc by cost in decreasing order
	 * @param dvds - an array of DigitalVideoDisc
	 * @return a sorted array of DigitalVideoDisc
	 */
	public static List<Media> sortByCost(List<Media> media) {
		Collections.sort(media, costComparator);
		return media;
	}
	
	/**
	 * Sort an array of DigitalVideoDisc by title in alphabetical order
	 * @param dvds an array of DigitalVideoDisc
	 * @return a sorted array of DigitalVideoDisc
	 */
	public static List<Media> sortByTitle(List<Media> media) {
		Collections.sort(media, titleComparator);
		return media;
	}
	
	/**
	 * Sort an array of DigitalVideoDisc by length in decreasing order
	 * @param dvds
	 * @return
	 */
	public static List<Media> sortByLength(List<Media> media) {
		Collections.sort(media, lengthComparator);
		return media;
	}
	
}
