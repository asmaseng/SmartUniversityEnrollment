import java.util.HashMap;
import java.util.Map;

public class CourseService {

    private final Map<String, Integer> courses = new HashMap<>();

    public CourseService() {
        courses.put("CS101", 30);
        courses.put("CS201", 2);
        courses.put("MATH101", 25);
    }

    public boolean courseExists(String courseId) {
        return courses.containsKey(courseId);
    }

    public boolean hasAvailableSeats(String courseId) {
        return courses.getOrDefault(courseId, 0) > 0;
    }

    public boolean reserveSeat(String courseId) {
        if (!hasAvailableSeats(courseId)) {
            return false;
        }

        courses.put(courseId, courses.get(courseId) - 1);
        return true;
    }

    public void releaseSeat(String courseId) {
        if (courseExists(courseId)) {
            courses.put(courseId, courses.get(courseId) + 1);
        }
    }
}
