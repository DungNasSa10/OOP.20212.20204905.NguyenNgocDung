package hust.soict.dsai.aims.media;

import java.time.LocalDate;

public abstract class Media {
	
	protected int id;
	protected String title;
	protected String category;
	protected float cost;
	protected static int nbMedia = 0;
	protected LocalDate dateAdded;

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public float getCost() {
		return cost;
	}

	public static int getNbMedia() {
		return nbMedia;
	}

	public LocalDate getDateAdded() {
		return dateAdded;
	}
	
	public Media(String title) {
		this.title = title;
		dateAdded = LocalDate.now();
		nbMedia++;
		id = nbMedia;
	}
	
	public Media(String title, String category) {
		this(title);
		this.category = category;
	}

	public Media(String title, String category, float cost) {
		this(title, category);
		this.cost = cost;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setCost(float cost) {
		this.cost = cost;
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
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Media) {
			try {
				Media medium = (Media) obj;
				boolean condition1 = this.title.equals(medium.getTitle());
				boolean condition2 = this.cost == medium.getCost();
				return condition1 && condition2;
			} catch (NullPointerException e) {
				return false;
			} catch (ClassCastException e) {
				return false;
			}
		} else {
			return false;
		}
	}

}
