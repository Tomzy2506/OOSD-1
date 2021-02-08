package lab1;

import java.util.Scanner;

public class Library {

	public static void main(String[] args) {
		
		Book[] books = new Book[3];
		Book book1 = new Book("java 101 ", "Pearse ", 4);

	    Book book2 = new Book(" C++ ", " Stormzy ", 400, 2, 9);

	    Book book3 = new Book(" java python ", " J.cole ", 800, 2);
		
		for(Book b: books) {
			if(b != null)System.out.println(b.toString());
		}
		
		books[1].Borrow();
		
		for(Book b: books) {
			if(b != null)System.out.println(b.toString());
		}
		
		books[1].BookReturn();
		
		for(Book b: books) {
			if(b != null)System.out.println(b.toString());
		}
		
	}//end main

}//end class
