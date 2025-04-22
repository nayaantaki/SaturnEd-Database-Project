import java.util.ArrayList;

public class Departments {
    private static int department_id_incrementer = 1;
    private static String[] deptStr = {"English",
            "Social Studies",
            "Biology",
            "Chemistry",
            "Physics",
            "Mathematics",
            "World Languages",
            "CTE",
            "Visual & Performing Arts",
            "Physical Education & Health"
    };
    public static ArrayList<Departments> arrDepartments = new ArrayList<Departments>();
    private int department_id;
    private String name;

    public Departments(String name) {
        department_id = department_id_incrementer;
        this.name = name;
        department_id_incrementer++;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public String getName() {
        return name;
    }

    public static void generateDepartments() {
        for (String dept : deptStr) {
            arrDepartments.add(new Departments(dept));
        }
    }

    @Override
    public String toString() {
        return "INSERT INTO Departments (department_id, name) VALUES ( " + (department_id) + ", '" + name + "' );";
    }

}
