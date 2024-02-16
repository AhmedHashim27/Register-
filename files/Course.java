public class Course implements Comparable<Course> {
    String dept;
    public Integer courseNum; // changed from int to Integer
    int section;
    String title;
    double credits;
    int maxEnrollment;
    String daysOfTheWeek;
    int startTime;
    int endTime;
    int duration;
    String timeString;
    String loc;
    String instructor;

    /**
     * Constructor takes in all values from the CSV.
     */
    public Course(String dept, int courseNum, int section, String title, double credits, int maxEnrollment, String daysOfTheWeek, int startTime,int endTime,int duration,String timeString, String loc, String instructor){
        //AFRS,100,51,Intro to Africana Studies,1,20,TR,810,885,75,0130PM-0245PM,BH 305,"Harriford, Diane"
        this.dept = dept;
        this.courseNum = courseNum;
        this.section = section;
        this.title = title;
        this.credits = credits;
        this.maxEnrollment = maxEnrollment;
        this.daysOfTheWeek = daysOfTheWeek;
        this.startTime = startTime;
        this.endTime = endTime;
        this.duration = duration;
        this.timeString = timeString;
        this.loc = loc;
        this.instructor = instructor;
    }
    
        public Integer getcourseNum() {
        return courseNum;
    }
    
    public void setCourseNum(Integer courseNum) {
        this.courseNum = courseNum;
    }
    
        public double getCourseNum() {
        return courseNum;
    }
    
        public double getcredits() {
        return credits;
    }
    
    public void setCredits(double credits) {
        this.credits = credits;
    }
    
    public String getTitle() {
        return title;
    }
    public int getSection() {
        return section;
    }
    
    public void setgetTitle(String title) {
        this.title = title;
    }
    
        public String getTimeString() {
        return timeString;
    }
    
    public void setTimeString(String timeString) {
        this.timeString = timeString;
    }
    
        public String getDayOfWeek() {
        return daysOfTheWeek;
    }
    
    public void setDayOfWeek(String daysOfTheWeek) {
        this.daysOfTheWeek = daysOfTheWeek;
    }
    
    
    
    

    /**
     * Key is a string representation of department-courseNumber-section.
     * Example: CMPU-102-51
     */
    public String getKey(){
        return dept + "-" + courseNum + "-" + section;
    }

    /**
     * Returns true if key is the same.  (Department, Course Number, and Section).
     * 
     */
    @Override
    public boolean equals(Object o){
        if(!(o instanceof  Course)){
            return false;
        }
        Course c = (Course) o;
        return this.getKey().equals(c.getKey());
    }

    

    /**
     * String representation as it might appear on askBanner.
     */
    public String toString(){
        return getKey() + " " + title + "\t" + credits + "\t" + daysOfTheWeek + " " + timeString;
    }

    /**
     * Should sort classes by department, then course number, then section. (just like
     * askBanner)
     */
    public int compareTo(Course c){
        if (c == null) {
            throw new NullPointerException("Cannot compare to a null Course object.");
        }
        int compareDepts = this.dept.compareTo(c.dept);
        if(compareDepts != 0){
            return compareDepts;
        } else {
            int compareCourseNum = Integer.compare(this.courseNum, c.courseNum);
            if(compareCourseNum != 0){
                return compareCourseNum;
            } else {
                return Integer.compare(this.section, c.section);
            }
        }
    }


        /**
         * a method that checks times and days to determine whether or not they overlap.
         */
    public boolean conflictsWith(Course maybe){
        // Check if the courses have overlapping days of the week
        for (char day : this.daysOfTheWeek.toCharArray()) {
            if (maybe.daysOfTheWeek.indexOf(day) != -1) {
                // If the courses meet on the same day of the week,
                // check if their time intervals overlap
                if (this.startTime >= maybe.startTime && this.startTime <= maybe.endTime) {
                    return true;
                }
                if (this.endTime >= maybe.startTime && this.endTime <= maybe.endTime) {
                    return true;
                }
                if (maybe.startTime >= this.startTime && maybe.startTime <= this.endTime) {
                    return true;
                }
                if (maybe.endTime >= this.startTime && maybe.endTime <= this.endTime) {
                    return true;
                }
            }
        }
        return false;
    }
    
}
