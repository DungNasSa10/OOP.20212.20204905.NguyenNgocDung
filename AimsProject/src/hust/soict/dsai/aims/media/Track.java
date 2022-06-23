package hust.soict.dsai.aims.media;

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
	
	public void play() {
		System.out.println("Playing Track: " + getTitle());
		System.out.println("Track length: " + getLength());
	}
	
	public String getInfo() {
		return "Playing Track: " + getTitle() + "\n" + "Track length: " + getLength();
	}

	public String toString() {
		return "Type: " + getType() + "Title: " + title + " - Length: " + length;
	}

	public String getType() {
		return "Track";
	}

}
