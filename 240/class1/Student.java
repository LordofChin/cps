//Deve: Carter R. Tufts
//Date: 1/13/2026
//Desc: intro to java

public class Student 
{
	int age;
	float cgpa;
	double height;
	boolean active;
	String name;

	public Student () 
	{
		this.age = 67;
		this.cgpa = 2.5f;
		this.height = 5.5;
		this.active = true;
		this.name = "Steve Jobs";
	}

	public static void main(String args[])
	{		
		Student steve = new Student();
		steve.display();		
	}
	public void display() 
	{
		System.out.printf("%s - %d - %f", this.name, this.age, this.cgpa);
	}
}
