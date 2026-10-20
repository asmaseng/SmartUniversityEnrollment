public class EnrollmentService {

    private boolean enrolled = false;

    public boolean isEnrolled() {
        return enrolled;
    }

    public void enroll(String studentId, String courseId) {
        enrolled = true;
        System.out.println("Student " + studentId + " enrolled in " + courseId);
    }

    public void cancel(String studentId, String courseId) {
        enrolled = false;
        System.out.println("Enrollment cancelled for " + studentId);
    }
}
