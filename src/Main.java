import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Rooms.generateRooms();
//        arrToTxt(Rooms.arrRooms, "inserts/rooms.txt");


        Departments.generateDepartments();
//        arrToTxt(Departments.arrDepartments, "inserts/departments.txt");


        Designations.generateDesignations();
//        arrToTxt(Designations.arrDesignations, "inserts/designations.txt");


        Weights.generateWeights();
//        arrToTxt(Weights.arrWeights, "inserts/weights.txt");


        Students.generateStudents();
//        arrToTxt(Students.arrStudents, "inserts/students.txt");


        Teachers.generateTeachers();
//        arrToTxt(Teachers.arrTeachers, "inserts/teachers.txt");

//        Courses.generateCourses();
////        System.out.println(Courses.arrCourses);
//
//        Offerings.generateOfferings();
////        System.out.println(Offerings.arrOfferings);
//
//        Rosters.generateRosters();
////        System.out.println(Rosters.arrRosters);
//
//        Assignments.generateAssignments();
////        System.out.println(Assignments.arrAssignments);
//
//        Grades.generateGrades();
////        System.out.println(Grades.arrGrades);
    }

    public static void arrToTxt(ArrayList<?> arrayList, String filePath){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (int i = 0; i < arrayList.size(); i++) {
                writer.write(arrayList.get(i).toString());
                writer.newLine();
            }

            System.out.println("File written successfully");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}