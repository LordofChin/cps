class Main {

    public static void main(String [] args) {
        //instantiating MyLinkedList of Students
        MyLinkedList<Student> students = new MyLinkedList<>();

        // add in the reqiured students
        students.add(new Student("Alice", 3.5, "Pass")); 
        students.add(new Student("Bob", 1.9, "Fail")); 
        students.add(new Student("Charlie", 2.8, "Pass")); 
        students.add(new Student("Diana", 1.5, "Fail")); 
        students.add(new Student("Ethan", 3.2, "Pass"));

        // print all students
        System.out.println("All Students:");
        System.out.println(students + "\n");

        // split and print passing and failing students
        splitAndPrint(students);
    }


    // method to split and print passing and failing students (putting in MyLinkedList class makes less sense)
    public static void splitAndPrint(MyLinkedList<Student> students) {
        // create two new MyLinkedLists for passing and failing students
        MyLinkedList<Student> passing = new MyLinkedList<>();
        MyLinkedList<Student> failing = new MyLinkedList<>();

        // iterate through the original list and separate students based on their status
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i).getValue();
            if (s.getStatus().equalsIgnoreCase("pass")) {
                passing.add(s);
            } else {
                failing.add(s);
            }
        }

        // print the passing and failing students
        System.out.println("Passing Students:");
        System.out.println(passing + "\n");
        System.out.println("Failing Students:");
        System.out.println(failing + "\n");
    }
}