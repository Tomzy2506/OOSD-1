package Lab7;

public class Cat extends Animal
{
	public Cat(String type, int age, char gender) 
	{
		super(type, age, gender);
	}

	@Override
	public void eat() 
	{
		System.out.println("The cat is eating");
	}
	@Override
	public void sleep() 
	{
		System.out.println("The cat is sleeping");
	}
	@Override
	public void makeSound() 
	{
		System.out.println("Meow");
	}

	@Override
	public String toString() 
	{
		return "Cat: " + super.toString();
	}
}