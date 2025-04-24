import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

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

        for (int i = 0; i < Assignments.arrAssignments.size(); i++) {
            Assignments currentAssignment = Assignments.arrAssignments.get(i);
            Offerings currentOffering = Assignments.arrAssignments.get(i).getOffering();

            ArrayList<Students> studentsInCurrentOffering = new ArrayList<Students>();
            for (int j = 0; j < Rosters.arrRosters.size(); j++) {
                if (Rosters.arrRosters.get(j).getOffering() == currentOffering){
                    studentsInCurrentOffering.add(Rosters.arrRosters.get(j).getStudent());
                }
            }

            for (int j = 0; j < studentsInCurrentOffering.size(); j++) {
                Random random = new Random();
                Grades.arrGrades.add(new Grades(studentsInCurrentOffering.get(j), currentAssignment, random.nextInt(75, 101)));
            }

        }
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
        return "INSERT INTO Grades (student_id, assignment_id, grade) VALUES ( " + student.getStudent_id() + ", " + assignment.getAssignment_id() + ", " + grade  + " );";
    }
}
