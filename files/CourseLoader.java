import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class CourseLoader here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CourseLoader extends DataLoader
{
    private List<Course> courses = new ArrayList<Course>();

    /**
     * Constructor calls the load(file) method in abstract parent class.
     * 
     * @param file: the path to the file.
     */
    public CourseLoader(String file){
        load(file);
    }

    /**
     * Parse a single line of CSV in the form:
     * dept, courseNum, section, name, credits, maxEnrol, days, startTime, EndTime, Duration, String time, room, professor
     * CMPU,145,51,Foundations/Computer Science,1,24,TRF,720,795,75,1200PM-0115PM,SP 309,Gomerschdat Anna
     * 
     * Method should create a new Course Object and add it to 
     * the students instance variable.
     * 
     * @param data: a single line from the csv file.
     */
    @Override
    public void parseAndLoadLine(String data) {
        try {
            // Split the data by commas to extract individual values
            String[] values = data.split(",");

            // Extract the values for each field
            String dept = values[0].trim();
            int courseNum = Integer.parseInt(values[1].trim());
            int section = Integer.parseInt(values[2].trim());
            String title = values[3].trim();
            double credits = Double.parseDouble(values[4].trim());
            int maxEnrollment = Integer.parseInt(values[5].trim());
            String daysOfTheWeek = values[6].trim();
            int startTime = Integer.parseInt(values[7].trim());
            int endTime = Integer.parseInt(values[8].trim());
            int duration = Integer.parseInt(values[9].trim());
            String timeString = values[10].trim();
            String loc = values[11].trim();
            String instructor = values[12].trim();
            // Create a new Course object with the extracted values
            Course course = new Course(dept, courseNum, section, title, credits, maxEnrollment,
                    daysOfTheWeek, startTime, endTime, duration, timeString, loc, instructor);
            // Add the Course object to the courses list
            courses.add(course);
        } catch (NumberFormatException e) {
            // Handle the case where one of the numeric values cannot be parsed
            System.out.println("Error: Invalid format for numeric value in input string: " + data);
        } catch (IndexOutOfBoundsException e) {
            // Handle the case where the input string does not have enough fields
            System.out.println("Error: Input string does not have enough fields: " + data);
        } catch (Exception e) {
            // Handle any other unexpected exceptions
            System.out.println("Error: " + e.getMessage());
        }
    }
    /**
     * Easy getter method to return the completed student roster.
     * @return students: the roster in the form of a List<Course>
     */
    public List<Course> getCourses(){
        return courses;
    }
}
