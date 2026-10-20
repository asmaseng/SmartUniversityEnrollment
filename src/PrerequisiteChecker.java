public class PrerequisiteChecker {

    public boolean checkPrerequisites(String studentId, String courseId) {
        if (courseId.equals("CS201")) {
            return studentId.equals("S001");
        }

        return true;
    }
}
