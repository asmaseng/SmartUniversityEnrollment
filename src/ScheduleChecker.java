import java.time.LocalTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ScheduleChecker {

    private final Map<String, Set<String>> studentSchedules =
            new HashMap<>();

    private final Map<String, LocalTime> courseStartTimes =
            new HashMap<>();

    private final Map<String, LocalTime> courseEndTimes =
            new HashMap<>();

    public ScheduleChecker() {

        courseStartTimes.put("CS101", LocalTime.of(9, 0));
        courseEndTimes.put("CS101", LocalTime.of(10, 30));

        courseStartTimes.put("CS201", LocalTime.of(11, 0));
        courseEndTimes.put("CS201", LocalTime.of(12, 30));

        courseStartTimes.put("MATH101", LocalTime.of(11, 0));
        courseEndTimes.put("MATH101", LocalTime.of(12, 30));

        studentSchedules.put("S001", new HashSet<>());
        studentSchedules.put("S002", new HashSet<>());
        studentSchedules.put("S003", new HashSet<>());
    }

    public boolean hasScheduleConflict(String studentId, String courseId) {

        LocalTime newStart = courseStartTimes.get(courseId);
        LocalTime newEnd = courseEndTimes.get(courseId);

        if (newStart == null || newEnd == null) {
            return true;
        }

        Set<String> enrolledCourses =
                studentSchedules.getOrDefault(studentId, new HashSet<>());

        for (String existingCourse : enrolledCourses) {

            LocalTime existingStart = courseStartTimes.get(existingCourse);
            LocalTime existingEnd = courseEndTimes.get(existingCourse);

            if (newStart.isBefore(existingEnd)
                    && newEnd.isAfter(existingStart)) {
                return true;
            }
        }

        return false;
    }

    public void addCourseToSchedule(String studentId, String courseId) {
        studentSchedules
                .computeIfAbsent(studentId, key -> new HashSet<>())
                .add(courseId);
    }

    public void removeCourseFromSchedule(String studentId, String courseId) {
        Set<String> courses = studentSchedules.get(studentId);

        if (courses != null) {
            courses.remove(courseId);
        }
    }
}
