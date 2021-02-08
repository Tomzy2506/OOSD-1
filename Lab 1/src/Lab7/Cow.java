package Lab7;

public class Cow extends Animal
{
	public Cow(String type, int age, char gender) 
	{
		super(type, age, gender);
	}

	@Override
	public void eat() 
	{
		System.out.println("The cow is eating");
	}
	@Override
	public void sleep() 
	{
		System.out.println("The cow is sleeping");
	}
	@Override
	public void makeSound() 
	{
		System.out.println("Moo");
	}

	@Override
	public String toString() 
	{
		return "Cow: " + super.toString();
	}
}