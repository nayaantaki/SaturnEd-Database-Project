import java.util.ArrayList;

public class Students {
    private static int student_id_incrementer = 1;
    private static String[] sdntStr = {};
    public static ArrayList<Students> arrStudents = new ArrayList<Students>();
    private int student_id;
    private String name;

    public Students(String name) {
        student_id = student_id_incrementer;
        this.name = name;
        student_id_incrementer++;
    }

    public static void generateStudents() {
        for (int i = 0; i < 5000; i++) {
            arrStudents.add(new Students("student" + (i + 1)));
        }
    }

    public int getStudent_id() {
        return student_id;
    }

    @Override
    public String toString() {
        return "INSERT INTO Students (student_id, name) VALUES ( " + (student_id) + ", '" + name + "' );";
    }

}
