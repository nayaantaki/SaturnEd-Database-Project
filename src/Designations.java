import java.util.ArrayList;

public class Designations {
    private static int designation_id_incrementer = 1;
    private static String[] desigStr = {"AP",
            "Regents",
            "Elective",
    };
    public static ArrayList<Designations> arrDesignations = new ArrayList<Designations>();
    private int designation_id;
    private String designation;

    public Designations(String name) {
        designation_id = designation_id_incrementer;
        this.designation = name;
        designation_id_incrementer++;
    }

    public static void generateDesignations() {
        for (String desig : desigStr) {
            arrDesignations.add(new Designations(desig));
        }
    }

    public int getDesignation_id() {
        return designation_id;
    }

    public String getDesignation() {
        return designation;
    }

    @Override
    public String toString() {
        return "INSERT INTO Designations (designation_id, designation) VALUES ( " + (designation_id) + ", '" + designation + "' );";
    }

}
