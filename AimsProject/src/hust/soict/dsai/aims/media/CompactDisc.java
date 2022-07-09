package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.exception.DuplicatedMediaException;
import hust.soict.dsai.aims.exception.NonExistingMediaException;
import hust.soict.dsai.aims.exception.PlayerException;

public class CompactDisc extends DigitalVideoDisc {
	
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
	
	public CompactDisc(String title, String category, String director, String artist, float cost) {
		this(title, category, director, cost);
		this.artist = artist;
	}
	
	public CompactDisc(String title, String category, String director, String artist, int length, float cost) {
		this(title, category, director, length, cost);
		this.artist = artist;
	}

	public String getArtist() {
		return artist;
	}
	
	public void addTrack(Track track) throws DuplicatedMediaException {
		if (tracks.contains(track)) {
			System.out.println("The track " + track.getTitle() + " is already in the list of tracks");
			throw new DuplicatedMediaException("ERROR: The track " + track.getTitle() + " is already in the list of tracks");
		} else {
			tracks.add(track);
			System.out.println("Successfully added the track " + track.getTitle() + " to the list of tracks");
		}
	}
	
	public void removeTrack(Track track) throws NonExistingMediaException {
		if (tracks.contains(track)) {
			tracks.remove(track);
			System.out.println("Successfully removed the track " + track.getTitle() + "from the list of tracks");
		} else {
			System.out.println("Remove failed! " +  track.getTitle() + " isn't in cart");
			throw new NonExistingMediaException("Remove failed! " +  track.getTitle() + " isn't in cart");
		}
	}
	
	public int getLength() {
		int totalLength = 0;
		for (Track track: tracks) {
			totalLength += track.getLength();
		}
		return totalLength;
	}
	
	public void play() throws PlayerException {
		if (getLength() > 0) {
			for (Track track: tracks) {
				try {
					track.play();
				} catch (PlayerException e) {
					throw e;
				}
			}
		} else {
			throw new PlayerException("ERROR: CD length is non-positive!");
		}
	}

	public String getType() {
		return "CD";
	}

	public String toString() {
		StringBuilder tracksInfo = new StringBuilder();
		tracksInfo.append("Tracks information: ");
		if (tracks.size() >= 1) {
			for (int i = 0; i < tracks.size(); i++) {
				tracksInfo.append("\n\t" + tracks.get(i).toString());
			} 
		}

		return ("Product ID: " + id
		+ "\n\t" + "Type: " + getType()
		+ "\n\t" + "Title: " + title
		+ "\n\t" + "Category: " + category
		+ "\n\t" + "Artist: " + artist
		+ "\n\t" + "Director: " + director
		+ "\n\t" + "Length: " + length
		+ "\n\t" + "Cost: " + cost + " $"
		+ "\n\t" + tracksInfo);
	}

	public List<Track> getTracks() {
		return tracks;
	}

}





