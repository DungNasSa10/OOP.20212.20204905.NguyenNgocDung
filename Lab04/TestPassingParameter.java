import java.util.concurrent.atomic.AtomicStampedReference;

public class TestPassingParameter {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
		WrapperDigitalVideoDisc wrapperJungleDVD = new WrapperDigitalVideoDisc(jungleDVD);
		WrapperDigitalVideoDisc wrapperCinderellaDVD = new WrapperDigitalVideoDisc(cinderellaDVD);
		
		swap(jungleDVD, cinderellaDVD);
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
		System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());
		
		changeTitle(jungleDVD, cinderellaDVD.getTitle());
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
		
		//Uncomment to test discSwap function
		//Need to comment line 16 and 17
		//swap(wrapperJungleDVD, wrapperCinderellaDVD);
		//System.out.println("wrapper jungle dvd title: " + wrapperJungleDVD.disc.getTitle());
		//System.out.println("wrapper cinderella title: " + wrapperCinderellaDVD.disc.getTitle());
	}
	
	public static void swap(Object o1, Object o2) {
		Object tmp = o1;
		o1 = o2;
		o2 = tmp;
	}
	
	// swap two objects using wrapper class
	public static void swap(WrapperDigitalVideoDisc wrapperDisc1, WrapperDigitalVideoDisc wrapperDisc2) {
		DigitalVideoDisc tmpDisc = wrapperDisc1.disc;
		wrapperDisc1.disc = wrapperDisc2.disc;
		wrapperDisc2.disc = tmpDisc;
	}
	
	public static void changeTitle(DigitalVideoDisc dvd, String title) {
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTitle);
	}
}