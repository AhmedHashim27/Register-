

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;

/**
 * The test class StudentLoaderTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class StudentLoaderTest
{
       @Test
    public void testStudentLoaderWithMultipleStudents(){
        String f = "shortRoster.csv";
        StudentLoader load = new StudentLoader(f);
        load.parseAndLoadLine("Hector Tran,999248624,2023,1");
        load.parseAndLoadLine("Chace Sanford,999248625,2023,2");
        load.parseAndLoadLine("Cade Young,999248626,2023,3");
    
        List<Student> expected = new ArrayList<Student>();
        expected.add(new Student("Hector Tran", 999248624, 2023, 1));
        expected.add(new Student("Chace Sanford", 999248625, 2023, 2));
        expected.add(new Student("Cade Young", 999248626, 2023, 3));
    
        List<Student> actual = load.getStudents();
    
        assertEquals(expected, actual);
    }
    
    @Test
    public void testStudentLoaderIncorrectInputWithEmptyFile() {
        String f2 = "invalid.csv";
        StudentLoader load = new StudentLoader(f2);
    
        List<Student> expected = new ArrayList<Student>();
        List<Student> actual = load.getStudents();
    
        assertEquals(expected, actual);
    }


    /**
     * Default constructor for test class StudentLoaderTest
     */
    public StudentLoaderTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
}
