import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EnrollmentService {

    private final Map<String, Set<String>> enrollments =
            new HashMap<>();

    public boolean isEnrolled(String studentId, String courseId) {

        Set<String> studentCourses =
                enrollments.get(studentId);

        return studentCourses != null
                && studentCourses.contains(courseId);
    }

    public boolean enrollStudent(String studentId, String courseId) {

        if (isEnrolled(studentId, courseId)) {
            return false;
        }

        enrollments
                .computeIfAbsent(studentId, key -> new HashSet<>())
                .add(courseId);

        return true;
    }

    public boolean cancelEnrollment(String studentId, String courseId) {

        Set<String> studentCourses =
                enrollments.get(studentId);

        if (studentCourses == null) {
            return false;
        }

        return studentCourses.remove(courseId);
    }

    public Set<String> getStudentCourses(String studentId) {

        return new HashSet<>(
                enrollments.getOrDefault(studentId, new HashSet<>())
        );
    }
}
