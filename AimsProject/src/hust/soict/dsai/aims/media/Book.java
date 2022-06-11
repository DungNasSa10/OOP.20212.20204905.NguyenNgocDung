package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.StringTokenizer;

public class Book extends Media {
	
	private String content;
	private Set<String> contentTokens = new TreeSet<String>();
	private Map<String, Integer> wordFrequency = new TreeMap<String, Integer>();
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

	public Book(String title, String category, String content, float cost) {
		this(title, category, cost);
		this.content = content;
		contentProcessing();
	}

	public int getContentLength() {
		int numTokens = 0;

		for (String word: wordFrequency.keySet()) {
			numTokens += wordFrequency.get(word);
		}

		return numTokens;
	}
	
	public void addAuthor(String authorName) {
		if (authors.contains(authorName)) {
			System.out.println(authorName + " is already in the list of authors");
			return;
		}
		authors.add(authorName);
		System.out.println("Successfully added " + authorName + " to the list of authors");
	}

	public void addAuthor(String ... authorNames) {
		for (String author: authorNames) {
			addAuthor(author);
		}
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

	public void removeAuthor(String ... authorNames) {
		for (String author: authorNames) {
			removeAuthor(author);
		}
	}

	public String getType() {
		return "Book";
	} 

	private void contentProcessing() {
		String regex = "[!._,'@? ]";
		StringTokenizer tokenizer = new StringTokenizer(content, regex);

		while (tokenizer.hasMoreTokens()) {
			String token = tokenizer.nextToken();
			if (wordFrequency.containsKey(token)) {
				wordFrequency.put(token, wordFrequency.get(token) + 1);
			} else {
				wordFrequency.put(token, 1);
			}
		}

		contentTokens = wordFrequency.keySet();
	}
	
	@Override
	public String toString() {
		StringBuilder authorsList = new StringBuilder();
		if (authors.size() >= 1) {
			authorsList.append(authors.get(0));
			for (int i = 1; i < authors.size(); i++) {
				authorsList.append(", " + authors.get(i));
			}
		}

		StringBuilder wordFreq = new StringBuilder();
		if (wordFrequency.keySet().size() >= 1) {
			for (String word: wordFrequency.keySet()) {
				wordFreq.append(word + ": " + wordFrequency.get(word) + ", ");
			}
		}

		return ("Product ID: " + id
		+ "\n\t" + "Type: " + getType()
		+ "\n\t" + "Title: " + title
		+ "\n\t" + "Category: " + category
		+ "\n\t" + "Authors: " + authorsList
		+ "\n\t" + "Content Length: " + getContentLength() + " tokens"
		+ "\n\t" + "Token List: " + contentTokens
		+ "\n\t" + "Token Frequency: " + wordFreq
		+ "\n\t" + "Cost: " + cost + " $");
	}
	
}








