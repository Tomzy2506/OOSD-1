package Lab7;

public class Dog extends Animal
{
	public Dog(String type, int age, char gender) 
	{
		super(type, age, gender);
	}

	@Override
	public void eat() 
	{
		System.out.println("The dog is eating");
	}
	@Override
	public void sleep() 
	{
		System.out.println("The dog is sleeping");
	}
	@Override
	public void makeSound() 
	{
		System.out.println("Woof woof");
	}

	@Override
	public String toString() 
	{
		return "Dog: " + super.toString();
	}
}