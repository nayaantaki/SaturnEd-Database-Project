import java.util.ArrayList;

public class Weights {
    private static int weight_id_incrementer = 1;
    private static String[] wghtStr = {"Major Assessment",
            "Minor Assessment"
    };
    public static ArrayList<Weights> arrWeights = new ArrayList<Weights>();
    private int weight_id;
    private String weight;

    public Weights(String weight) {
        weight_id = weight_id_incrementer;
        this.weight = weight;
        weight_id_incrementer++;
    }

    public static void generateWeights() {
        for (String wght : wghtStr) {
            arrWeights.add(new Weights(wght));
        }
    }

    public int getWeight_id() {
        return weight_id;
    }

    @Override
    public String toString() {
        return "INSERT INTO Weights (weight_id, weight) VALUES ( " + (weight_id) + ", '" + weight + "' );";
    }

}
