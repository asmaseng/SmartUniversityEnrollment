import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PrerequisiteChecker {

    private final Map<String, Set<String>> completedCourses =
            new HashMap<>();

    private final Map<String, String> prerequisites =
            new HashMap<>();

    public PrerequisiteChecker() {

        Set<String> asanaliCourses = new HashSet<>();
        asanaliCourses.add("CS101");

        completedCourses.put("S001", asanaliCourses);
        completedCourses.put("S002", new HashSet<>());
        completedCourses.put("S003", new HashSet<>());

        prerequisites.put("CS201", "CS101");
    }

    public boolean checkPrerequisites(String studentId, String courseId) {

        if (!prerequisites.containsKey(courseId)) {
            return true;
        }

        String requiredCourse = prerequisites.get(courseId);

        Set<String> studentCourses =
                completedCourses.getOrDefault(studentId, new HashSet<>());

        return studentCourses.contains(requiredCourse);
    }
}
