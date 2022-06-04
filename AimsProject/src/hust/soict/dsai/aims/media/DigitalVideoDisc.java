package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
	
	private String director;
	private int length;

	public DigitalVideoDisc(String title) {
		super(title);
	}
	
	public DigitalVideoDisc(String title, String category) {
		super(title, category);
	}
	
	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost);
	}
	
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(title, category, director, cost);
	}
	
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title, category, director, length, cost);
	}
	
	public String toString() {
		return "Id: " + id + " - " + "Title: " + title + " - " + "Category: " + category + " - " + "Director: " + director + " - " + "Length: " + length + " - " + "Cost: " + cost + " $";
	}
	
	public boolean isMatch(String title) {
		String[] tokens = this.title.toLowerCase().split(" ");
		for (String token: tokens) {
			if (title.toLowerCase().contains(token)) {
				return true;
			}
		}
		return false;
	}
	
	public void play() {
		System.out.println("Playing DVD: " + getTitle());
		System.out.println("DVD length: " + getLength());
	}
	
}


