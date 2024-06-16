/**
 * Bookstore Tracking System
 * 
 * This Java program serves as a bookstore tracking system. It allows users to perform
 * various tasks related to managing a bookstore's inventory, such as adding new books,
 * updating book information, and searching for books by author or price. The class includes
 * initialization of variables, default and parametric constructor, getters and setters,
 * and methods used in the main. 
 * 
 * Author: [Dalia Betinjaneh]
 * Date: [Monday September 18th]
 * Course: [COMP 249]
 */


public class Book {

	// initialize the variables
	private String title;
	private String author;
	private long ISBN;
	private double price;
	private int numBooks = 0;
	private static int numBookscnt = 1;
	
	// default constructor
	public Book() {
		title = "";
		author = "";
		ISBN = 0;
		price = 0;
		numBooks = numBookscnt;
		numBookscnt++;
	}
	
	// getters
	public String getTitle() {
		return title;
		
	}
	
	public String getAuthor() {
		return author;
	}
	
	public long getISBN() {
		return ISBN;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int getNumBooks() {
		return numBooks;
	}
	
	public static int getNumBookscnt() {
		return numBookscnt;
	}
	
	// setters
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setISBN(long ISBN) {
		this.ISBN = ISBN;
	}
	
	public void setNumBooks(int numBooks) {
		this.numBooks = numBooks;
	}
	
	public static void setNumBookscnt(int count) {
		numBookscnt = count;
	}
	
	// parametric constructor
		public Book (String t, String a, long i, double p){
			title = t;
			author = a;
			ISBN = i;
			price = p;
			numBooks = numBookscnt;
			numBookscnt++;
		}
	
	// Method that finds number of books
	public static int findNumberOfCreatedBooks() {
		return numBookscnt - 1;
	}
	
	public boolean equalsTo(Book b1, Book b2) {
		return b1.ISBN==b2.ISBN && b1.price==b2.price;
	}
	
	public String toString() {
		return "Book " + numBooks + "\nAuthor: " + author + "\nTitle: " + title + "\nISBN: " + ISBN + "\nPrice: $" + price + "\n";
	}
	
	
}
