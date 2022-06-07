package hust.soict.dsai.test.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.utils.MediaUtils;

public class MediaUtilsTest {

	public static void main(String[] args) {
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("AAAA", "aaaa", "aaaa", 1, 5.6f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("BBBB", "bbbb", "bbbb", 2, 5.3f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("CCCC", "cccc", "cccc", 3, 5f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("DDDD", "dddd", "dddd", 4, 7.1f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("EEEE", "eeee", "eeee", 5, 3.3f);
		
		System.out.println(MediaUtils.compareByCost(dvd1, dvd2));
		System.out.println(MediaUtils.compareByTitle(dvd5, dvd3));
		
		List<Media> sorted = new ArrayList<Media>();
		sorted.add(dvd1);
		sorted.add(dvd2);
		sorted.add(dvd3);
		sorted.add(dvd4);
		sorted.add(dvd5);
		
		sorted = MediaUtils.sortByCost(sorted);
		System.out.println("sort by cost: ");
		for (Media medium: sorted) {
			System.out.println(medium);
		}
		
		sorted = MediaUtils.sortByTitle(sorted);
		System.out.println("sort by cost: ");
		for (Media medium: sorted) {
			System.out.println(medium);
		}
	}

}
