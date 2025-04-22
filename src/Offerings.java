import java.util.ArrayList;
import java.util.HashMap;


public class Offerings {
    private static int offering_id_incremeneter = 1;
    public static ArrayList<Offerings> arrOfferings = new ArrayList<Offerings>();
    private int offering_id;
    private Courses course;
    private Teachers teacher;
    private Rooms room;
    private int period;


    public Offerings(Courses course, Teachers teacher, Rooms room, int period) {
        offering_id = offering_id_incremeneter;
        this.course = course;
        this.teacher = teacher;
        this.room = room;
        this.period = period;
        offering_id_incremeneter++;
    }


    public static void generateOfferings() {
        Courses.generateCourses();
        Teachers.generateTeachers();
        Rooms.generateRooms();

        HashMap<Courses, Integer> rates = offeringRates();


        for (int i = 0; i < Courses.arrCourses.size(); i++) {
            int iterate = rates.get(Courses.arrCourses.get(i));
            for (int j = 0; j < iterate; j++) {
                Offerings potentialOffering = genSingleOffering(i);
                if (! (Offerings.arrOfferings.isEmpty())) {
                    boolean unsafe = false;
                    while (!unsafe) {
                        for (int k = 0; k < arrOfferings.size(); k++) {
                            if (arrOfferings.get(i).period == potentialOffering.period && (arrOfferings.get(i).room == potentialOffering.room || arrOfferings.get(i).teacher == potentialOffering.teacher)) { //crashes on occasion...
                                unsafe = true;
                            }
                            potentialOffering = genSingleOffering(i);
                        }
                    }
                }
                arrOfferings.add(potentialOffering);
            }
        }
    }


    public static int generateRandom(int bounds){
        return (int)(Math.random()*(bounds - 1)) + 1;
    }


    private static Offerings genSingleOffering(int i) {
        Courses currentCourse = Courses.arrCourses.get(i);
        Teachers currentTeacher = Teachers.arrTeachers.get(generateRandom(312));
        Rooms currentRooms = Rooms.arrRooms.get(generateRandom(720));
        int period = generateRandom(11);
        return new Offerings(currentCourse, currentTeacher, currentRooms, period);
    }


    private static HashMap<Courses, Integer> offeringRates() {
        HashMap<Courses, Integer> offerRates = new HashMap<Courses, Integer>();
        for (int i = 0; i < Courses.arrCourses.size(); i++) {
            int rate = generateRandom(6);
            offerRates.put(Courses.arrCourses.get(i), rate);
        }
        return offerRates;
    }


    public int getOffering_id() {
        return offering_id;
    }

    public int getPeriod() {
        return period;
    }

    @Override
    public String toString() {
        return "INSERT INTO Offerings (offering_id, course_id, teacher_id, room_id, period) VALUES ( " + offering_id + ", " + course.getCourse_id() + ", " + teacher.getTeacher_id() + ", " + room.getRoom_id() + ", " + period + " ); \n";
    }
}