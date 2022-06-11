package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	
	private int contentLength;
	private List<String> authors = new ArrayList<String>();

	public Book(String title) {
		super(title);
	}
	
	public Book(String title, String category) {
		super(title, category);
	}
	
	public Book(String title, String category, float cost) {
		super(title, category, cost);
	}

	public Book(String title, String category, int contentLength, float cost) {
		this(title, category, cost);
		this.contentLength = contentLength;
	}

	public int getContentLength() {
		return contentLength;
	}
	
	public void addAuthor(String authorName) {
		if (authors.contains(authorName)) {
			System.out.println(authorName + " is already in the list of authors");
			return;
		}
		authors.add(authorName);
		System.out.println("Successfully added " + authorName + " to the list of authors");
	}
	
	public void removeAuthor(String authorName) {
		for (String name: authors) {
			if (authorName.toLowerCase().equals(name.toLowerCase())) {
				authors.remove(name);
				System.out.println("Successfully removed " + authorName + " from the list of authors");
				return;
			}
		}
		System.out.println(authorName + " isn't in the list of authors");
	}

	public String getType() {
		return "Book";
	} 
	
	@Override
	public String toString() {
		StringBuilder authorsList = new StringBuilder();
		if (authors.size() >= 1) {
			for (int i = 0; i < authors.size(); i++) {
				authorsList.append(", " + authors.get(i));
			}
		}

		return ("Product ID: " + id
		+ "\n\t" + "Type: " + getType()
		+ "\n" + "\t" + "Title: " + title
		+ "\n" + "\t" + "Category: " + category
		+ "\n" + "\t" + "Authors: " + authorsList
		+ "\n" + "\t" + "Content Length: " + contentLength + " tokens"
		+ "\n" + "\t" + "Cost: " + cost + " $");
	}
	
}








