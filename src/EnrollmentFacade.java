public class EnrollmentFacade {

    private final StudentService student = new StudentService();
    private final CourseService course = new CourseService();
    private final PrerequisiteChecker prerequisite = new PrerequisiteChecker();
    private final ScheduleChecker schedule = new ScheduleChecker();
    private final EnrollmentService enrollment = new EnrollmentService();

    public void enrollStudent(String studentId, String courseId) {

        if (!student.checkStudent(studentId)) {
            System.out.println("Student not found");
            return;
        }

        if (!course.checkCourse(courseId)) {
            System.out.println("Course not found");
            return;
        }

        if (enrollment.isEnrolled()) {
            System.out.println("Already enrolled");
            return;
        }

        if (!prerequisite.checkPrerequisites(studentId, courseId)) {
            System.out.println("Prerequisites not completed");
            return;
        }

        if (!schedule.checkSchedule(studentId, courseId)) {
            System.out.println("Schedule conflict");
            return;
        }

        if (!course.checkSeats()) {
            System.out.println("No available seats");
            return;
        }

        course.reserveSeat();
        enrollment.enroll(studentId, courseId);
        System.out.println("Enrollment successful");
    }

    public void cancelEnrollment(String studentId, String courseId) {

        if (!enrollment.isEnrolled()) {
            System.out.println("No enrollment found");
            return;
        }

        enrollment.cancel(studentId, courseId);
        course.releaseSeat();
    }
}
