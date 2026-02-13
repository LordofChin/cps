import java.util.ArrayList;
import java.util.Collections;

public class Driver {

    public static boolean compareCourseLists(ArrayList<String> courses1, ArrayList<String> courses2){
        if(courses1.size() != courses2.size()) return false;
	for(String course : courses1) {
		if (!courses2.remove(course)) return false;
	}
	if (courses2.size() == 0) return true;
	return false;
    }


    public static void main(String[] args){

        ArrayList<String> student1Courses = new ArrayList<>();
        student1Courses.add("Data Structures");
        student1Courses.add("Operating Systems");
        student1Courses.add("Databases");
        student1Courses.add("Networks");

        ArrayList<String> student2Courses = new ArrayList<>();
        student2Courses.add("Networks");
        student2Courses.add("Databases");
        student2Courses.add("Operating Systems");
        student2Courses.add("Data Structures");

        ArrayList<String> student3Courses = new ArrayList<>();
        student3Courses.add("Data Structures");
        student3Courses.add("Databases");

        System.out.println(compareCourseLists(student1Courses, student2Courses)
                ? "Student 1 and Student 2 have identical course enrollment."
                : "Student 1 and Student 2 do NOT have identical course enrollment.");

        System.out.println(compareCourseLists(student1Courses, student3Courses)
                ? "Student 1 and Student 3 have identical course enrollment."
                : "Student 1 and Student 3 do NOT have identical course enrollment.");
    }
}
