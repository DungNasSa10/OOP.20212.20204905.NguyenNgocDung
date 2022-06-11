package hust.soict.dsai.aims.media;

public class Disc extends Media {
	
	protected int length;
	protected String director;

	public Disc(String title) {
		super(title);
	}
	
	public Disc(String title, String category) {
		super(title, category);
	}
	
	public Disc(String title, String category, float cost) {
		super(title, category, cost);
	}
	
	public Disc(String title, String category, String director, float cost) {
		this(title, category, cost);
		this.director = director;
	}
	
	public Disc(String title, String category, String director, int length, float cost) {
		this(title, category, director, cost);
		this.length = length;
	}

	public int getLength() {
		return length;
	}

	public String getDirector() {
		return director;
	}

	public String getType() {
		return "Disc";
	}
	
	@Override
	public String toString() {
		return ("Product ID: " + id
		+ "\n\t" + "Type: " + getType()
		+ "\n\t" + "Title: " + title
		+ "\n\t" + "Category: " + category
		+ "\n\t" + "Director: " + director
		+ "\n\t" + "Length: " + length
		+ "\n\t" + "Cost: " + cost + " $");
	}

	public void setLength(int length) {
		this.length = length;
	}

	public void setDirector(String director) {
		this.director = director;
	}

}
