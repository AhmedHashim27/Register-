# Pre-registration

## Description:
An implementation of Vassar College's Registrar's Pre-registration algorithm. It takes 3 CSV files as inputs, then the algorithm will run through the Registrar's process for assigning schedules.

### CSV Files Included:

- **course_fullRequests.csv**:
  - A full list of Vassar course requests which each includes:
    - Department, CourseNumber, Section, Title, Credits, MaxEnrollment, DaysOfTheWeek, StartTime, EndTime, Duration (in min), Time, Location, and Instructor

- **course_shortRequests.csv**:
  - A short list of Vassar course requests (includes the same elements as course_fullRequests.csv)

- **fullRequests.csv**:
  - A full list of a student's ID number along with their course requests

- **shortRequests.csv**:
  - A full list of a student's ID number along with their course requests

- **fullRoster.csv**:
  - A full list of students including:
    - Name, ID number, graduation year, and draw number

- **shortRoster.csv**:
  - A full list of students (includes the same elements as fullRoster.csv)

### How to Use:

Download files. Within Preregistration/src, run the Main class to see students get their respective course requests added to their schedule according to the following criteria:

- Students are allowed a maximum of 4.5 credits
- Students will not be enrolled if the requested course has reached capacity
- Students will not be enrolled if the requested course is already registered for the same course in a different section
- Students will not be enrolled if the requested course has a time conflict with a course already in their schedule
