public class StudentService {

    public boolean checkStudent(String studentId) {
        return studentId.equals("S001") || studentId.equals("S002");
    }
}
