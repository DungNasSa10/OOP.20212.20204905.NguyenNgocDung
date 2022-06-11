package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class Track implements Playable, Comparable<Track> {
	
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
		if (length == 0) {
			System.out.println("Can't play track " + title + " of lenth 0");
		} else {
			System.out.println("Playing Track: " + getTitle());
			System.out.println("Track length: " + getLength());
		}
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Track) {
			Track track = (Track) o;
			return title.equals(track.getTitle()) && length == track.getLength();
		} else {
			return false;
		}
	}

	@Override
	public int compareTo(Track o) {
		Track track = (Track) o;
		return Comparator.comparing(Track::getTitle)
						.thenComparing(Comparator.comparingInt(Track::getLength).reversed())
						.compare(this, track);
	}

	public String getType() {
		return "Track";
	}

}
