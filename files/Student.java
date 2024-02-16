import java.util.List;
import java.util.ArrayList;

public class Student implements Comparable<Student>{
    String name;
    int idNum;
    int gradYear;
    int drawNumber;
    public List<Course> requests;
    public List<Course> schedule;
    private ArrayList<Course> registeredCourses;

    /**
     * @param name: string the student's first and last name;
     * @param idNum: int the student's 999 number.
     * @param gradYear: 4 digit graduation year.
     * @param drawNumber: the draw number determines the student's place in the algorithm.
     */
    public Student(String name, int idNum, int gradYear,int drawNumber){
        this.name = name;
        this.idNum = idNum;
        this.gradYear = gradYear;
        this.drawNumber = drawNumber;
        this.requests = new ArrayList<Course>();
        this.schedule = new ArrayList<Course>();
        this.registeredCourses = new ArrayList<Course>();

    }

    public int getGradYear() {
        return gradYear;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void setGradYear(int gradYear) {
        this.gradYear = gradYear;
    }

    public int getDrawNumber() {
        return drawNumber;
    }

    public void setDrawNumber(int drawNumber) {
        this.drawNumber = drawNumber;
    }

    public List<Course> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<Course> schedule) {
        this.schedule = schedule;
    }

    public List<Course> getRequests() {
        return requests;
    }

    public void setRequests(List<Course> requests) {
        this.requests = requests;
    }

    /**
     * Returns true if idNumbers are the same;
     * @param Object: any possible object.  
     * 
     * @return boolean: true if idNumbers are the same.
     */
    public boolean equals(Object o){
        if((o instanceof Student)){
            return idNum == ((Student)(o)).idNum;
        }
        return false;
    }

    /**
     * ToString returns a string representation including 
     * name, graduation year and draw number.
     */
    public String toString(){
        return name + " " + gradYear + " " + drawNumber;
    }

    /**
     * Write a compareTo that sorts the student by draw number and
     * class year.  
     * The first person should be a 4th year with draw number 1.
     * The last person should be a 1st year with a the largest draw number.
     * All 4th years come before all 3rd years, etc.
     * 
     * @return retval: 
     *    1 if the first thing comes first, 
     *    0 if they are equal
     *    -1 if the second thing comes firt.
     */

    public int compareTo(Student other) {
        int result = Integer.compare(gradYear, other.gradYear);
        if (result == 0) {
            result = Integer.compare(idNum, other.idNum);
        }
        return result;
    }

    /**
     * Check to see if the student is registered for any section of a course.
     * @param maybe: Course.  The potential course to register for.
     * 
     * @return boolean: true if the student is registered for any section of the course.
     */
    /**
     * Check to see if the student is registered for any section of a course.
     * @param maybe: Course.  The potential course to register for.
     * 
     * @return boolean: true if the student is registered for any section of the course.
     */
    public boolean isRegisteredFor(Course maybe) {
        return schedule.stream().anyMatch(course -> course.title.equals(maybe.title) && course.courseNum == maybe.courseNum || course.conflictsWith(maybe));
    }


    /**
     * @return the total registered credits (limit is 4.5)
     */
    public double totalRegisteredCredits() {
        return schedule.stream().mapToDouble(course -> course.getcredits()).sum();
    }

    /**
     * @param maybe: Course the potential course
     * 
     * @return true if the student already has something at that time.
     */
    public boolean hasAConflict(Course maybe) {
        return schedule.stream().anyMatch(course -> course.conflictsWith(maybe));
    }

    /**
     * Check if a course can be added without exceeding the maximum credit limit and creating any time conflicts.
     * @param course: Course. The course to check.
     * 
     * @return boolean: true if the course can be added.
     */
    public boolean courseAddable(Student student, Course course) {
        double totalCredits = totalRegisteredCredits() + course.getcredits();
        if (totalCredits > 4.5) {
            return false; // Return false if adding the course would exceed the maximum credit limit
        }
        if (hasAConflict(course)) {
            return false; // Return false if adding the course would create a time conflict
        }
        if (isRegisteredFor(course)) {
            return false; // Return false if the student is already registered for the course
        }
        return true; // Return true if the course can be added without any issues
    }
}
