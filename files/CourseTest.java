

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class CourseTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CourseTest
{
    
    
     @Test
    public void testCompareTo(){
        Course course1 = new Course("CHEM",125, 91,"Chemical Principles",0.0,16,"F",810,1050,240,"0130PM-0530PM","BLS 119", "Kusmierska-Gomez Anita");
        Course course2 = new Course("RUSS",211,51,"Intermediate Russian",1,18,"MWF",720,795,75,"1200PM-0115PM","CH 118","Tcherkassova Farida");
        int actual = course1.compareTo(course2);
        int expected = -15;
        assertEquals(expected, actual);
        
        //FFS	106	51	Elementary French	1	20	MTWRF	570	620	50	0930AM-1020AM	CH LL104	Brancky Anne
        Course course3 = new Course("CMPU",252,51,"Elementary French",1,20,"MTWRF",570,620,50,"0930AM-1020AM","CH LL104","Brancky Anne "); 
        Course course4 = new Course("CMPU",250,51,"The Russian Modernists(in Eng)",1,18,"TR",910,985,75,"0310PM-0425PM","CH 118","Tcherkassova Farida");
        int actual1 = course3.compareTo(course4);
        int expected1 = 1;
        assertEquals(expected1, actual1);
    }

    @Test public void testConflictsWith(){
        //doesnt overlap
        Course course1 = new Course("CHEM",125, 91,"Chemical Principles",0.0,16,"F",810,1050,240,"0130PM-0530PM","BLS 119", "Kusmierska-Gomez Anita");
        Course course2 = new Course("RUSS",211,51,"Intermediate Russian",1,18,"MWF",720,795,75,"1200PM-0115PM","CH 118","Tcherkassova Farida");
        boolean actual = course1.conflictsWith(course2);
        boolean expected = false;
        assertEquals(expected, actual);
        
        //overlaps
        Course course3 = new Course("AMST",329,51,"American Literary Realism",1,15,"W",780,900,120,"0100PM-0300PM","RH 301","Graham Wendy"); 
        Course course4 = new Course("DRAM",339,51,"Shakespeare in Production",1,12,"W",780,900,120,"0100PM-0300PM","PT AUD","Walen Denise");
        boolean actual1 = course3.conflictsWith(course4);
        boolean expected1 = true;
        assertEquals(expected1, actual1);
        
    }
    
    
    /**
     * Default constructor for test class CourseTest
     */
    public CourseTest()
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
