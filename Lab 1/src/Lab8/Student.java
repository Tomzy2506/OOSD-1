package Lab8;

public class Student extends Person 
{
	String course;
	
	public Student(String name, String course)
	{
		super(name);
		setCourse(course);
	}

	public String getDescription() 
	{
		return "A Student studying " + course;
	}

	public String getCourse() 
	{
		return course;
	}
	public void setCourse(String course) 
	{
		this.course = course;
	}
	

}