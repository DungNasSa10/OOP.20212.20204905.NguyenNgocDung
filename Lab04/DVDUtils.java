import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


public class DVDUtils {
	/**
	 * helper attributes used for sorting methods
	 */
	private static Comparator<DigitalVideoDisc> costComparator = new Comparator<DigitalVideoDisc>() {
		@Override
		public int compare(DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
			return Float.compare(disc2.getCost(), disc1.getCost());
		}
	}; 
	
	private static Comparator<DigitalVideoDisc> titleComparator = new Comparator<DigitalVideoDisc>() {
		@Override
		public int compare(DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
			return disc1.getTitle().compareTo(disc2.getTitle());
		}
	}; 
	
	private static Comparator<DigitalVideoDisc> lengthComparator = new Comparator<DigitalVideoDisc>() {
		@Override
		public int compare(DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
			return Integer.compare(disc2.getLength(), disc1.getLength());
		}
	};
	
	public static String compareByCost(DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
		float comparedResult = disc1.getCost() - disc2.getCost();
		
		if (comparedResult < 0) {
			return "The first DVD is cheaper than the second one";
		} else if (comparedResult == 0) {
			return "Two DVDs have the same price";
		} else {
			return "The first DVD is more expensive than the second one";
		}
	}
	
	public static String compareByTitle(DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
		int comparedResult = disc1.getTitle().compareTo(disc2.getTitle());
		
		if (comparedResult < 0) {
			return "The first DVD's title is smaller than that of the secone one in alphabetical order";
		} else if (comparedResult == 0) {
			return "Two DVDs have identical title";
		} else {
			return "The first DVD's title is larger than that of the secone one in alphabetical order";
		}
	}
	
	
	/**
	 * Sort an array of DigitalVideoDisc by cost in decreasing order
	 * @param dvds - an array of DigitalVideoDisc
	 * @return a sorted array of DigitalVideoDisc
	 */
	public static DigitalVideoDisc[] sortByCost(DigitalVideoDisc[] dvds) {
		Arrays.sort(dvds, costComparator);
		return dvds;
	}
	
	/**
	 * Sort an array of DigitalVideoDisc by title in alphabetical order
	 * @param dvds an array of DigitalVideoDisc
	 * @return a sorted array of DigitalVideoDisc
	 */
	public static DigitalVideoDisc[] sortByTitle(DigitalVideoDisc[] dvds) {
		Arrays.sort(dvds, titleComparator);
		return dvds;
	}
	
	/**
	 * Sort an array of DigitalVideoDisc by length in decreasing order
	 * @param dvds
	 * @return
	 */
	public static DigitalVideoDisc[] sortByLength(DigitalVideoDisc[] dvds) {
		Arrays.sort(dvds, lengthComparator);
		return dvds;
	}
	
}
