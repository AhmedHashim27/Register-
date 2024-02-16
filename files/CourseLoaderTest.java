

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


/**
 * The test class CourseLoaderTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CourseLoaderTest
{
    

       @Test
    public void testCourseLoader() {
        String file = "shortRequests.csv";
        CourseLoader load = new CourseLoader(file);
        load.parseAndLoadLine("DANC, 266, 51, Intermediate Ballet III, 1, 6, MWF, 810, 900, 90, 0130PM-0300PM, KH 120 , Mahdaviani Miriam");
        List<Course> expected = new ArrayList<Course>();
        expected.add(new Course("DANC", 266, 51, "Intermediate Ballet III", 1, 6, "MWF", 810, 900, 90, "0130PM-0300PM", "KH 120", "Mahdaviani Miriam"));
        List<Course> actual = load.getCourses();
    
        assertEquals(expected.get(0), actual.get(0));
    }

    @Test
    public void testCourseLoaderIncorrectInput() {
        String file = "invalid.csv";
        CourseLoader load = new CourseLoader(file);
    
        List<Course> expected = new ArrayList<Course>();
        List<Course> actual = load.getCourses();
    
        assertEquals(expected, actual);
    }

    /**
     * Default constructor for test class CourseLoaderTest
     */
    public CourseLoaderTest()
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
