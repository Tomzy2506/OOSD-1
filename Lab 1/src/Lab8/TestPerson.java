package Lab8;

public class TestPerson 
{
	public static void main(String[] args) 
	{
		Employee emp = new Employee("Tom", 60000);
		
		Student stu = new Student("Mary", "Programming");
		
		Person[] people = new Person[2];
		
		people[0] = emp;
		people[1] = stu;
		
		for(Person p: people)
		{
			System.out.println("Name: " + p.getName() + "\t" + "Description: " + p.getDescription());
		}
	}
}
