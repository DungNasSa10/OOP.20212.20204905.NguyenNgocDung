package hust.soict.dsai.test.media;

import hust.soict.dsai.aims.media.Book;

public class BookTest {
    
    public static void main(String[] args) {
        Book book = new Book("Intro to AI", "Science", "Hello Hi, Hello World! Python Java hello Machine Learning.!! Deep Learning Reinforcement Learning",  100f);
        book.addAuthor("Turing");
        book.addAuthor("Einstein", "Newton", "A");
        book.removeAuthor("A");
        System.out.println(book);
    }
}
