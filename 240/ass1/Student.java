public class Student 
{
    //required fields
    private String name;
    private double gpa;
    private String status;


    // constructors

    // parameterized constructor
    public Student(String name, double gpa, String status) {
        this.name = name;
        this.gpa = gpa;
        this.status = status;
    }

    // default constructor
    public Student() {
        this.name = null;
        this.gpa = 0.0;
        this.status = null;
    }

    // getters and setters
    public String getName() {
        return name;
    }
    public double getGpa() {
        return gpa;
    }
    public String getStatus() {
        return status;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    // toString method as asked
    @Override
    public String toString() {
        return "Name: " + name + ", GPA: " + gpa + ", Status: " + status;
    }

}