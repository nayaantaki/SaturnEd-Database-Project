import java.util.ArrayList;

public class Rooms {
    private static int room_id_incrementer = 1;
    public static ArrayList<Rooms> arrRooms = new ArrayList<Rooms>();
    private int room_id;
    private String room;

    public Rooms(String room) {
        this.room_id = room_id_incrementer;
        this.room = room;
        room_id_incrementer++;
    }

    public static void generateRooms() {
        String[] directions = {"N", "E", "S", "W"};

        for (int i = 0; i < directions.length; i++) {
            String directionInUse = directions[i];
            for (int j = 0; j < 9; j++) {
                for (int k = 1; k < 21; k++) {
                    String room = "";
                    if (j == 0) {
                        room = "B" + directionInUse + k;
                    } else {
                        room = j + directionInUse + k;
                    }
                    arrRooms.add(new Rooms(room));
                }
            }
        }
    }

    public int getRoom_id() {
        return room_id;
    }

    @Override
    public String toString() {
        return "INSERT INTO Rooms (room_id, room) VALUES ( " + (room_id) + ", '" + room + "' );";
    }
}
