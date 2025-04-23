import java.util.ArrayList;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Rooms.generateRooms();
//        System.out.println(Rooms.arrRooms);

        Departments.generateDepartments();
//        System.out.println(Departments.arrDepartments);

        Designations.generateDesignations();
//        System.out.println(Designations.arrDesignations);

        Weights.generateWeights();
//        System.out.println(Weights.arrWeights);

        Students.generateStudents();
//        System.out.println(Students.arrStudents);

        Teachers.generateTeachers();
//        System.out.println(Teachers.arrTeachers);

        Courses.generateCourses();
//        System.out.println(Courses.arrCourses);

        Offerings.generateOfferings();
//        System.out.println(Offerings.arrOfferings);

        Rosters.generateRosters();
//        System.out.println(Rosters.arrRosters);

        Assignments.generateAssignments();
//        System.out.println(Assignments.arrAssignments);

        Grades.generateGrades();
//        System.out.println(Grades.arrGrades);
    }
}