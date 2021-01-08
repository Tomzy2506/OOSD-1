package lab3;

public class RecDriver {

	public static void main(String[] args) {

		Rectangle rec = new Rectangle();
		
		System.out.println(rec);
		
		rec.setLength(10.0F);
		rec.setWidth(20.0F);
		
		System.out.println(rec);
		
		rec.setLength(50.0F);
		rec.setWidth(-20.0F);
		
		System.out.println(rec);
		
		System.out.println("The area is: " + rec.getArea());
		
		System.out.println("The perimeter is: " + rec.getPerimeter());
		
		rec.printRectangle();

	}

}
