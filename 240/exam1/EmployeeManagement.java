abstract class Employee {

    public abstract void calculateSalary();
}

class FullTimeEmployee extends Employee {

    public void calculateSalary(){
        System.out.println("Calculating salary for full-time employee");
    }
}

class PartTimeEmployee extends Employee {

    public void calculateSalary(){
        System.out.println("Calculating salary for part-time employee");
    }
}

public class EmployeeManagement {

    public static void main(String[] args){

        Employee emp1 = new FullTimeEmployee();
        Employee emp2 = new PartTimeEmployee();

        processSalary(emp1);
        processSalary(emp2);

    }

    public static void processSalary(Employee emp){
        emp.calculateSalary();
    }

}