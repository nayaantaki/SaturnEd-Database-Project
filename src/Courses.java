import java.util.ArrayList;

public class Courses {
    private static String[] courseStr = { "Chemistry|Regents Chemistry",
            "Chemistry|Organic Chemistry",
            "Chemistry|Chemical Engineering",
            "Chemistry|Modern Instrumental Chemical Analysis",
            "Chemistry|Quantitative Analysis",
            "Chemistry|Forensic Science",
            "Chemistry|AP Chemistry",
            "CTE|AP Computer Science Principles",
            "CTE|AP Computer Science A",
            "CTE|Big Data: Warehousing & Analytics",
            "CTE|Cyber Security",
            "CTE|Statics",
            "CTE|Strength Of Materials",
            "CTE|Web Development",
            "CTE|Digital Systems Design",
            "CTE|Fundamentals of IT Infrastructure",
            "CTE|PLTW Digital Electronics",
            "CTE|PLTW Green Building Construction",
            "CTE|PLTW Engineering Design & Development",
            "CTE|PLTW Computer Integrated Manufacturing",
            "Social Studies|9th Grade Pre-AP World History",
            "Social Studies|10th Grade Regents Global History",
            "Social Studies|11th Grade Regents United States History",
            "Social Studies|Participation in Government",
            "Social Studies|Economics",
            "Social Studies|Sociology",
            "Social Studies|Cultural Anthropology",
            "Social Studies|Physical Anthropology",
            "Social Studies|AP World History",
            "Social Studies|AP European History",
            "Social Studies|AP United States History",
            "Social Studies|AP United States Government",
            "Social Studies|AP Macroeconomics",
            "Social Studies|AP Microeconomics",
            "Social Studies|AP Comparative Government",
            "Social Studies|AP Psychology",
            "Social Studies|AP Human Geography",
            "Visual & Performing Arts|Basic Strings",
            "Visual & Performing Arts|Musicianship and Chorus",
            "Visual & Performing Arts|Collaborative Piano/Choral Accompaniment",
            "Visual & Performing Arts|Concert Band",
            "Visual & Performing Arts|Concert Choir",
            "Visual & Performing Arts|Intermediate Orchestra",
            "Visual & Performing Arts|Jazz Band",
            "Visual & Performing Arts|Junior Band",
            "Visual & Performing Arts|Orchestra",
            "Visual & Performing Arts|String Orchestra",
            "Visual & Performing Arts|Symphonic Band",
            "Visual & Performing Arts|Treble Choir",
            "Visual & Performing Arts|Tech Chorale",
            "Visual & Performing Arts|Stageworks",
            "Visual & Performing Arts|AP Visual & Performing Arts Theory",
            "Visual & Performing Arts|PLTW Design and Drafting Production",
            "World Languages|Chinese I",
            "World Languages|Chinese II",
            "World Languages|Chinese III",
            "World Languages|French I",
            "World Languages|French II",
            "World Languages|French III",
            "World Languages|German I",
            "World Languages|German II",
            "World Languages|German III",
            "World Languages|Italian I",
            "World Languages|Italian II",
            "World Languages|Italian III",
            "World Languages|Spanish I",
            "World Languages|Spanish II",
            "World Languages|Spanish III",
            "World Languages|Spanish IV",
            "World Languages|AP Chinese Language and Culture",
            "World Languages|AP French Language and Culture",
            "World Languages|AP German Language and Culture",
            "World Languages|AP Italian Language and Culture",
            "World Languages|AP Spanish Language and Culture",
            "World Languages|AP Spanish Literature and Culture",
            "Physics|Regents Physics",
            "Physics|Astronomy",
            "Physics|Modern Physics",
            "Physics|AP Physics 1",
            "Physics|AP Physics 2",
            "Physics|AP Physics C (Mechanics)",
            "Physics|AP Physics C (E/M)",
            "Physical Education & Health|Health Education",
            "Physical Education & Health|Physical Education - General",
            "Physical Education & Health|Badminton/Pickleball",
            "Physical Education & Health|Basketball",
            "Physical Education & Health|Backyard Games",
            "Physical Education & Health|Floor Hockey",
            "Physical Education & Health|Handball",
            "Physical Education & Health|Volleyball",
            "Physical Education & Health|Indoor Soccer",
            "Physical Education & Health|Team Handball",
            "Physical Education & Health|Advanced Weight Training",
            "Physical Education & Health|Indoor Track",
            "Physical Education & Health|Outdoor Track",
            "Physical Education & Health|Tennis",
            "Biology|Anatomy",
            "Biology|AP Biology",
            "Biology|AP Environmental Sciences",
            "Biology|AP Psychology",
            "Biology|Bioorganic Chemistry",
            "Biology|Genetics",
            "Biology|Introduction to Neuroscience",
            "Biology|Regents Living Environment",
            "Biology|Living Environment Lab",
            "Biology|Environmental Sustainability",
            "Mathematics|Regents Algebra",
            "Mathematics|Regents Geometry",
            "Mathematics|Regents Algebra II",
            "Mathematics|Precalculus",
            "Mathematics|Calculus",
            "Mathematics|AP Calculus AB",
            "Mathematics|AP Calculus BC",
            "Mathematics|AP Statistics",
            "Mathematics|Multivariable Calculus",
            "Mathematics|Linear Algebra",
            "Mathematics|Math Research",
            "English|9th Grade English",
            "English|10th Grade English",
            "English|Regents 11th Grade English",
            "English|12th Grade English",
            "English|AP English Language and Composition",
            "English|AP Capstone Research",
            "English|AP English Literature and Composition",
            "English|Creative Writing",
            "English|Drama",
            "English|Film and Literature",
            "English|Journalism",
            "English|Life, Love, and Death",
            "English|Mystery Horror and the Supernatural",
            "English|Science Fiction and Fantasy"
    };
    private static int course_id_incrementer = 1;
    public static ArrayList<Courses> arrCourses = new ArrayList<Courses>();
    private int course_id;
    private String name;
    private Departments department;
    private Designations designation;

    public Courses(String name, Departments department, Designations designation) {
        course_id = course_id_incrementer;
        this.name = name;
        this.department = department;
        this.designation = designation;
        course_id_incrementer++;
    }

    public static void generateCourses() {
        Departments.generateDepartments();
        Designations.generateDesignations();

        for (int i = 0; i < courseStr.length; i++) {
            String courseName = courseStr[i].substring(courseStr[i].indexOf("|") + 1);
            String dept = courseStr[i].substring(0, courseStr[i].indexOf("|"));
            Designations currentDesig = Designations.arrDesignations.getLast();

            String courseTitleDesig;
            if (courseName.contains("AP")) {
                courseTitleDesig = "AP";
            } else if (courseName.contains("Regents")) {
                courseTitleDesig = "Regents";
            } else {
                courseTitleDesig = "Elective";
            }

            for (int j = 0; j < Designations.arrDesignations.size(); j++) {
                if (Designations.arrDesignations.get(j).getDesignation().contains(courseTitleDesig) && courseName.contains(courseTitleDesig)) {
                    currentDesig = Designations.arrDesignations.get(j);
                }
            }

            for (int k = 0; k < Departments.arrDepartments.size(); k++) {
                if (Departments.arrDepartments.get(k).getName().equals(dept)) {
                    arrCourses.add(new Courses(courseName, Departments.arrDepartments.get(k), currentDesig));
                }
            }
        }
    }

    public int getCourse_id() {
        return course_id;
    }

    @Override
    public String toString() {
        return "INSERT INTO Courses (course_id, name, department_id, designation_id) VALUES ( " + course_id + ", '" + name + "', " + department.getDepartment_id() + ", " + designation.getDesignation_id() + " );";
    }
}
