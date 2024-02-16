import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class StudentLoader here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StudentLoader extends DataLoader
{
    private List<Student> students = new ArrayList<>(); // Instance variable to store Student objects

    
    /**
     * Constructor calls the load(file) method in abstract parent class.
     * 
     * @param file: the path to the file.
     */
    public StudentLoader(String file){
        load(file);
    }
    
    /**
     * Parse a single line of CSV in the form:
     * Name, idNum, gradYear, drawNummber
     * Hector Tran,999248624,2023,1
     * 
     * Method should create a new Student Object and add it to 
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
            String name = values[0];
            int idNum = Integer.parseInt(values[1]);
            int gradYear = Integer.parseInt(values[2]);
            int drawNum = Integer.parseInt(values[3]);
            // Create a new Student object with the extracted values
            Student student = new Student(name, idNum, gradYear, drawNum);
            // Add the Student object to the students list
            students.add(student);
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
     * 
     * @return students: the roster in the form of a List<Student>
     */
        // Getters
    public List<Student> getStudents(){
        return students;
    }
    
}
