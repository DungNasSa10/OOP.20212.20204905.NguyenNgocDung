package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	
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
	
	@Override
	public String toString() {
		return "Id: " + id + " - " + "Title: " + title + " - " + "Category: " + category + " - " + " - " + "Cost: " + cost + " $";
	}
	
}








