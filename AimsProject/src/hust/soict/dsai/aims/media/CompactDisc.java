package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends DigitalVideoDisc implements Playable {
	
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();

	public CompactDisc(String title) {
		super(title);
	}
	
	public CompactDisc(String title, String category) {
		super(title, category);
	}

	public CompactDisc(String title, String category, float cost) {
		super(title, category, cost);
	}

	public CompactDisc(String title, String category, String director, float cost) {
		super(title, category, director, cost);
	}

	public CompactDisc(String title, String category, String director, int length, float cost) {
		super(title, category, director, length, cost);
	}

	public String getArtist() {
		return artist;
	}
	
	public CompactDisc(String title, String category, String director, String artist, int length, float cost) {
		this(title, category, director, length, cost);
		this.artist = artist;
	}
	
	public void addTrack(Track track) {
		if (tracks.contains(track)) {
			System.out.println("The track " + track.getTitle() + " is already in the list of tracks");
		} else {
			tracks.add(track);
			System.out.println("Successfully added the track " + track.getTitle() + " to the list of tracks");
		}
	}
	
	public void removeTrack(Track track) {
		if (tracks.contains(track)) {
			tracks.remove(track);
			System.out.println("Successfully removed the track " + track.getTitle() + "from the list of tracks");
		} else {
			System.out.println("Remove failed! " +  track.getTitle() + " isn't in cart");
		}
	}
	
	public int getLength() {
		int totalLength = 0;
		for (Track track: tracks) {
			totalLength += track.getLength();
		}
		return totalLength;
	}
	
	public void play() {
		for (Track track: tracks) {
			track.play();
		}
	}

}





