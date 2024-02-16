import java.util.*;

public class Algorithm {
    private HashMap<Course, Integer> enrollment;
    private HashMap<Integer, PriorityQueue<Student>> studentsByClass;
    private HashMap<Integer, Stack<Student>> studentsStackByClass;

    public Algorithm(List<Student> stuMap, HashMap<Course,Integer> enrollment) {
        this.enrollment = enrollment;
        this.studentsByClass = new HashMap<Integer, PriorityQueue<Student>>();
        this.studentsStackByClass = new HashMap<Integer,Stack<Student>>();

        // initialize the PriorityQueue and Stack for each class
        for (Student student : stuMap) {
            int classYear = student.gradYear;
            if (!studentsByClass.containsKey(classYear)) {
                studentsByClass.put(classYear, new PriorityQueue<Student>());
                studentsStackByClass.put(classYear, new Stack<Student>());
            }
            studentsByClass.get(classYear).add(student);
        }
    }

    public void run() {
        List<Integer> gradYears = new ArrayList<>(studentsByClass.keySet());
        Collections.sort(gradYears);
        boolean isForward = true;
        int numIterations = 7;

        for (int i = 0; i < numIterations; i++) {
            if (!isForward) {
                Collections.reverse(gradYears);
            }

            for (int gradYear : gradYears) {
                PriorityQueue<Student> students = studentsByClass.get(gradYear);
                Stack<Student> stuStack = studentsStackByClass.get(gradYear);

                if (isForward) {
                    while (!students.isEmpty()) {
                        Student student = students.poll();
                        enrollment(student);
                        stuStack.push(student);
                    }
                } else {
                    while (!stuStack.isEmpty()) {
                        Student student = stuStack.pop();
                        enrollment(student);
                        students.offer(student);
                    }
                }
            }

            isForward = !isForward;
        }
    }

    public boolean enrollment(Student student){
        for (Course course : student.requests) {
            while (enrollment.get(course) < course.maxEnrollment && student.courseAddable(student, course)) {
                enrollment.put(course, enrollment.get(course) + 1);
                student.schedule.add(course);
                return true; // Success!
            }
        }
        return false; // Could not enroll in any requested course
    }


 public void printEnrollment() {
    studentsByClass.entrySet().stream()
        .flatMap(entry -> studentsStackByClass.get(entry.getKey()).stream())
        .forEach(student -> {
            System.out.println(student.toString());
            student.schedule.stream().forEach(course -> System.out.println(course.toString()));
            System.out.println("--------------------");
        });
}

}
