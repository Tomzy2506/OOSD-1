package Lab9;

public class LibraryPOS 
{
	public static void main(String[] args)
	{
		Book b = new Book("Peasrson", "Java Programming", 200);
		
		CD c = new CD("Faithless", "Faithless", 12);
		
		LibraryItem[] items = new LibraryItem[2];
		
		items[0] = b;
		items[1] = c;
		
		for(LibraryItem i: items)
		{
			System.out.println(i);
		}
		
		double totalLoanPrice = 0;
		
		for(LibraryItem x: items)
		{
			totalLoanPrice += x.calculatePrice();
		}
		
		System.out.println("Total Price: " + totalLoanPrice);
	}
}