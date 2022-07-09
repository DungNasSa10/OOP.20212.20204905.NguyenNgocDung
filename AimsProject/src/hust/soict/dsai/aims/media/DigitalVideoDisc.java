package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {

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
	
	public void play() throws PlayerException {
		if (getLength() > 0) {
			System.out.println("Playing DVD: " + getTitle());
			System.out.println("DVD length: " + getLength());
		} else {
			throw new PlayerException("ERROR: DVD length is non-positive!");
		}
	}
	
	public String getInfo() throws PlayerException {
		play();
		return "Playing DVD: " + getTitle() + "\n" + "Length: " + getLength();
	}

	public String getType() {
		return "DVD";
	}
	
}


