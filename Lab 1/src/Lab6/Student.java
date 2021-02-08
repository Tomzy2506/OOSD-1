package Lab6;

import java.util.Arrays;

public class Student extends Person
{
	///Variables
	private int numCourses;
	private String[] courses;
	private int[] grades;
	private static final int MAXCOURSES = 10;
	
	public Student(String name, String address) 
	{
		super(name, address);
		numCourses = 0;
		courses = new String[MAXCOURSES];
		grades = new int [MAXCOURSES];
	}
	
	public void addCourseGrade(String course, int grade)
	{
		courses[numCourses] = course;
		grades[numCourses] = grade;
		numCourses++;
	}
	
	public void printGrades()
	{
		System.out.print(this);
		for(int i = 0; i <= courses.length - 1; i++)
		{
			System.out.println("Course: " + courses[i] + "Grade: " + grades[i]);
		}
	}
	
	public double getAverageGrade()
	{
		int sum = 0;
		for(int gr: grades)
		{
			sum += gr;
		}
		return sum/numCourses;
	}
	
	///toString
	@Override
	public String toString() 
	{
		return "Student [numCourses=" + numCourses + ", courses=" + Arrays.toString(courses) + ", grades="
				+ Arrays.toString(grades) + "]";
	}
}