import java.util.HashMap;
import java.util.Map;

public class StudentService {

    private final Map<String, String> students = new HashMap<>();

    public StudentService() {
        students.put("S001", "Asanali");
        students.put("S002", "Dias");
        students.put("S003", "Aruzhan");
    }

    public boolean studentExists(String studentId) {
        return students.containsKey(studentId);
    }

    public String getStudentName(String studentId) {
        return students.get(studentId);
    }
}
