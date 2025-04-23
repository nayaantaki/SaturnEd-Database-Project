import java.util.ArrayList;


public class Assignments {
    private static int assignments_id_incrementer = 1;
    private int assignment_id;
    String name;
    Weights weight;
    Offerings offering;
    public static ArrayList<Assignments> arrAssignments = new ArrayList<Assignments>();

    public Assignments(String name, Weights weight, Offerings offering){
        assignment_id = assignments_id_incrementer;
        this.name = name;
        this.weight = weight;
        this.offering = offering;
        assignments_id_incrementer++;
    }

    public static void generateAssignments(){
        Weights.generateWeights();

        for (int i = 0; i < Offerings.arrOfferings.size(); i++) {
            for (int j = 1; j < 13; j++) {
                String missName = "minorAssignment" + j;
                arrAssignments.add(new Assignments(missName, Weights.arrWeights.get(1), Offerings.arrOfferings.get(i)));
            }
            for (int j = 1; j < 4; j++) {
                String massName = "majorAssignment" + j;
                arrAssignments.add(new Assignments(massName, Weights.arrWeights.get(0), Offerings.arrOfferings.get(i)));
            }
        }
    }


    public int getAssignment_id(){
        return assignment_id;
    }

    @Override
    public String toString() {
        return "INSERT INTO Assignments (assignment_id, name, weight_id, offering_id) VALUES ( " + assignment_id + ", '" + name + "', " + weight.getWeight_id() + ", " + offering.getOffering_id()  + "); \n";
    }
}

