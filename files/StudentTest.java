

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


/**
 * The test class StudentTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class StudentTest {
    
@Test
public void testStudentSort() {
    List<Student> students = new ArrayList<>();
    students.add(new Student("randall Reid", 999249376, 2024, 3));
    students.add(new Student("Conrad Mckenzie", 999250124, 2025, 1));
    students.add(new Student("Mark Peters", 999250874, 2026, 1));
    students.add(new Student("Aiden Zamora",999250875, 2026, 2));

    Collections.sort(students);

    assertEquals(students.get(0), new Student("randall Reid", 999249376, 2024, 3));
    assertEquals(students.get(1), new Student("Conrad Mckenzie", 999250124, 2025, 1));
    assertEquals(students.get(2), new Student("Mark Peters", 999250874, 2026, 1));
    assertEquals(students.get(3), new Student("Aiden Zamora", 999250875, 2026, 2));
}



    /**
     * Default constructor for test class StudentTest
     */
    public StudentTest()
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
