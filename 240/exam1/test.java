import java.util.LinkedList;

public class StudentList {
    public static void main(String[] args){

        LinkedList<String> students = new LinkedList<>();

        students.add(Ali);
        students.add(Sara);
        students.add(John);
                        try{
            processStudent(students);
                        } catch(IndexOutOfBoundsException e) {
                                    System.out.println("Error: " + e);
                        }
                        
    }

    public static void processStudent(LinkedList<String> students) throws ArrayIndexOutOfBoundsException {
            students.remove(3);

    }
}
