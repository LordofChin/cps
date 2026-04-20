// DATE:        04-08-2026
// DEVELOPER:   Carter Reid Tufts
// DESCRIPTION: This class represents a student with their personal details and academic information.

public class Student 
{
    // private fields
    private String firstName;
    private String lastName;
    private String dob;
    private String cgpa;
    private String adminssionDate;

        /**
        * Constructs a new Student object with the specified details.
        *
        * @param firstName      the first name of the student
        * @param lastName       the last name of the student
        * @param dob            the date of birth of the student
        * @param cgpa           the cumulative grade point average of the student
        * @param adminssionDate the admission date of the student
        */
    public Student(String firstName, String lastName, String dob, String cgpa, String adminssionDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.cgpa = cgpa;
        this.adminssionDate = adminssionDate;
    }

        /**
         * Constructs a new Student object by parsing a comma-separated string.
         * @param line          a comma-separated string containing the student's details in the order: firstName, lastName, dob, cgpa, adminssionDate
         */
    public Student(String line) {
        String[] data = line.split(",");
        this.firstName = data[0];
        this.lastName = data[1];
        this.dob = data[2];
        this.cgpa = data[3];
        this.adminssionDate = data[4];
    }

    // getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDob() {
        return dob;
    }

    public String getCgpa() {
        return cgpa;
    }

    public String getAdminssionDate() {
        return adminssionDate;
    }

    // setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setCgpa(String cgpa) {
        this.cgpa = cgpa;
    }

    public void setAdminssionDate(String adminssionDate) {
        this.adminssionDate = adminssionDate;
    }

    @Override
    public String toString() {
        // format: John Doe | DOB: 2000-01-01 | CGPA: 3.5 | Admission: 2022-09-01
        return String.format("%s | DOB: %s | CGPA: %s | Admission: %s", firstName + " " +lastName, dob, cgpa, adminssionDate);
    }

}