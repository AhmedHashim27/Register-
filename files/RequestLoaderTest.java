

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashMap;

/**
 * The test class RequestLoaderTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class RequestLoaderTest {
@Test
    public void testRequestLoader() {
        String hectorRequest = "999248624,CMPU-145-51,CMPU-145-52,EDUC-361-51,ECON-235-51,PHED-105-51,ECON-235-51,COGS-311-51";
        StudentLoader ifstu = new StudentLoader("../data/shortRoster.csv");
        CourseLoader mycour = new CourseLoader("../data/course_shortRequests.csv");
        RequestLoader requesty = new RequestLoader("../data/shortRequests.csv", ifstu.getStudents(), mycour.getCourses());
        requesty.parseAndLoadLine(hectorRequest);
        if (requesty.mapStudents.containsKey(999248624)) {
            Course student1 = requesty.mapStudents.get(999248624).requests.get(0);
            Course student2 = requesty.mapCourses.get("CMPU-145-51");
            assertEquals(student1, student2);
        } else {
            fail("Key not found in mapStudents");
        }
    }

    
    /**
     * Default constructor for test class RequestLoaderTest
     */
    public RequestLoaderTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp() {
        StudentLoader ifstu = new StudentLoader("../data/shortRoster.csv");
        System.out.println(ifstu.getStudents());
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
