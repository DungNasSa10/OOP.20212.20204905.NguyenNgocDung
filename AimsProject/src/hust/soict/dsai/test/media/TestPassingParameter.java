package hust.soict.dsai.test.media;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class TestPassingParameter {
	
	public static void main(String[] args) {
		Media jungleDVD = new DigitalVideoDisc("Jungle");
		Media cinderellaDVD = new DigitalVideoDisc("Cinderella");
		//WrapperMedia wrapperJungleDVD = new WrapperMedia(jungleDVD);
		//WrapperMedia wrapperCinderellaDVD = new WrapperMedia(cinderellaDVD);
		
		swap(jungleDVD, cinderellaDVD);
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
		System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());
		
		changeTitle(jungleDVD, cinderellaDVD.getTitle());
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
		
		//Uncomment lines 11, 12, 23, 24, 25 to test swap function to swap two dvds
		//Need to comment line 18 and 19
		//swap(wrapperJungleDVD, wrapperCinderellaDVD);
		//System.out.println("wrapper jungle title: " + wrapperJungleDVD.medium.getTitle());
		//System.out.println("wrapper cinderella title: " + wrapperCinderellaDVD.medium.getTitle());
	}
	
	public static void swap(Object o1, Object o2) {
		Object tmp = o1;
		o1 = o2;
		o2 = tmp;
	}
	
	// swap two objects using wrapper class
	public static void swap(WrapperMedia wrapperDisc1, WrapperMedia wrapperDisc2) {
		Media tmpDisc = wrapperDisc1.medium;
		wrapperDisc1.medium = wrapperDisc2.medium;
		wrapperDisc2.medium = tmpDisc;
	}
	
	public static void changeTitle(Media dvd, String title) {
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTitle);
	}
}