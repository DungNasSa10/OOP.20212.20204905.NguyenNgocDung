package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class Track implements Playable {
	
	private String title;
	private int length;

	public Track(String title) {
		this.title = title;
	}
	
	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}

	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}
	
	public void play() throws PlayerException {
		if (getLength() > 0) {
			System.out.println("Playing Track: " + getTitle());
			System.out.println("Track length: " + getLength());
		} else {
			throw new PlayerException("ERROR: DVD length is non-positive!");
		}
	}
	
	public String getInfo() throws PlayerException {
		play();
		return "Playing Track: " + getTitle() + "\n" + "Track length: " + getLength();
	}

	public String toString() {
		return "Type: " + getType() + "Title: " + title + "Length: " + length;
	}

	public String getType() {
		return "Track";
	}

}
