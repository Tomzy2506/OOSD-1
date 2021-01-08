package lab3;

public class Rectangle {
	
	//Variables
	private float length;
	private float width;
		
	//Constructors
	public Rectangle() {
		setLength(1.0F);
		setWidth(1.0F);
	}
	
	//Getters & Setters
	public float getLength() {
		return length;
	}
	public void setLength(float length) {
		if(length > 0.0 && length <= 40.0) {
			this.length = length;
		}
		else {
			System.out.println("The length must be between 0.0 and 40.0");
		}
	}
	public float getWidth() {
		return width;
	}
	public void setWidth(float width) {
		if(width > 0.0 && width <= 40.0) {
		this.width = width;
		}
		else {
			System.out.println("The width must be between 0.0 and 40.0");
		}
	}
	
	
	//toString
	@Override
	public String toString() {
		return "Rectangle [length=" + length + ", width=" + width + "]";
	}
	
	//Misc Methods
	public float getArea() {
		return length * width;
	}
	
	public float getPerimeter() {
		return 2*(length + width);
	}
	
	
	
	
	
}
