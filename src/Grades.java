import java.util.ArrayList;

public class Grades {
    public static ArrayList<Grades> arrGrades = new ArrayList<Grades>();
    private Students student;
    private Assignments assignment;
    private int grade;

    public Grades(Students student, Assignments assignment, int grade) {
        this.student = student;
        this.assignment = assignment;
        this.grade = grade;
    }

    public static void generateGrades(){
        //go to each assignment in assignment array
        //go to the offering
        //for all items in the roster array with that offering take the student object
        //attach assignment, student, and randomized grade number
    }


    public int getGrade() {
        return grade;
    }

    public Assignments getAssignment() {
        return assignment;
    }

    public Students getStudent() {
        return student;
    }

    @Override
    public String toString() {
        return "grade";
    }
}
