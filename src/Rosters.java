import java.util.ArrayList;
import java.util.Random;

public class Rosters {
    private static int roster_id_incrementer = 1;
    public static ArrayList<Rosters> arrRosters = new ArrayList<Rosters>();
    private int roster_id;
    private Students student;
    private Offerings offering;

    public Rosters(Students student, Offerings offering) {
        roster_id = roster_id_incrementer;
        this.student = student;
        this.offering = offering;
        roster_id_incrementer++;
    }

    public static void generateRosters(){
        Random random = new Random();

        for (int i = 0; i < Students.arrStudents.size(); i++) {
            for (int j = 1; j < 11; j++) {
                ArrayList<Offerings> potentialOfferings = offeringsOccuringInAPeriod(j);
                Rosters.arrRosters.add(new Rosters(Students.arrStudents.get(i), potentialOfferings.get(random.nextInt(potentialOfferings.size()))));
            }
        }
    }

    public static ArrayList<Offerings> offeringsOccuringInAPeriod(int period){
        Random random = new Random();
        ArrayList<Offerings> acceptedOfferings = new ArrayList<Offerings>();
        for (int i = 0; i < Offerings.arrOfferings.size(); i++) {
            if (Offerings.arrOfferings.get(i).getPeriod() == period){
                acceptedOfferings.add(Offerings.arrOfferings.get(i));
            }
        }
        return acceptedOfferings;
    }

    public int getRoster_id() {
        return roster_id;
    }

    public Students getStudent() {
        return student;
    }

    public Offerings getOffering() {
        return offering;
    }

    @Override
    public String toString() {
        return "INSERT INTO Rosters ( student_id, offering_id ) VALUES ( " + student.getStudent_id() + ", " + offering.getOffering_id() + " );";
    }
}
