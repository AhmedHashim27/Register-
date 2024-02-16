import java.util.*;

/**
 * Write a description of class RequestLoader here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RequestLoader extends DataLoader {

    public HashMap<Integer, Student> mapStudents = new HashMap<Integer,Student>();  // Initialize mapStudents
    public HashMap<String, Course> mapCourses = new HashMap<String,Course>(); // Initialize mapCourses

    /**
     * Constructor creates hashMaps for students and courses.  
     * mapStudents: idNum is the key.
     * mapCourses: courseKey (string) is the key, 
     * 
     * calls the load(file) method in abstract parent class.
     * 
     * @param file: the path to the file.
     * @param students: List of students successfully loaded from file
     * @param courses:  List of courses successfully loaded from file
     */
    public RequestLoader(String file, List<Student> students, List<Course> courses) {

        for (Student s : students) {
            mapStudents.put(s.idNum, s);
        }

        for (Course c : courses) {
            mapCourses.put(c.getKey(), c);
        }

        load(file);
    }

    /**
     * Parse a single line of CSV in the form:
     * studentId, Course 1, course 2, course 3, course 4, course 5, course 6, course 7
     * 999248624,CMPU-145-51,CMPU-145-52,EDUC-361-51,ECON-235-51,PHED-105-51,ECON-235-51,COGS-311-51
     * 
     * Method should 
     * 1) extract the studentId and find the associated Student in mapStudents.
     * 2) extract the courseKey and find the associated Course in mapCourses
     * 3) add the course to the student requests.
     * 
     * @param data: a single line from the csv file.
     * parse
     */
    @Override
    public void parseAndLoadLine(String data) {
        String[] tokens = data.split(",");
        String studentId = tokens[0];
        Student student = null;

        try {
            student = mapStudents.get(Integer.parseInt(studentId));
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid format for student ID in input string: " + data);
            return;
        }
        if (student == null) {
            System.out.println("Error: Student not found with ID: " + studentId);
            return;
        }
        for (int i = 1; i < tokens.length; i++) {
            String courseKey = tokens[i];
            Course course = mapCourses.get(courseKey);
            if (course != null) {
                System.out.println(course);
                //if (!student.requests.contains(course) && !student.schedule.contains(course)) {
                student.requests.add(course);
                //System.out.println("added");
                //} else {
                //System.out.println("not_added");
                //} 
            } else {
                System.out.println("Error: Course not found with key: " + courseKey);
            }
            System.out.println(student);
        }
        // Update the student object in the mapStudents HashMap
        mapStudents.put(student.idNum, student);
    }


    /**
     * Method takes finished hashmap of students with all of their requests and turns
     * it back into a List, sorts it, and returns it.
     * 
     * @return students: list of all students and their requests sorted by drawNumber and Class
     * (as specified in the Student compareTo method task).
     */
    public List<Student> mapStudentRequests(){
        List<Student> students = new ArrayList<Student>();
        students.addAll(mapStudents.values());
        Collections.sort(students);
        return students;
    }
}
