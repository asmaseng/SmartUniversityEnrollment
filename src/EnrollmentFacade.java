public class EnrollmentFacade {

    private final StudentService studentService;
    private final CourseService courseService;
    private final PrerequisiteChecker prerequisiteChecker;
    private final ScheduleChecker scheduleChecker;
    private final EnrollmentService enrollmentService;

    public EnrollmentFacade() {
        studentService = new StudentService();
        courseService = new CourseService();
        prerequisiteChecker = new PrerequisiteChecker();
        scheduleChecker = new ScheduleChecker();
        enrollmentService = new EnrollmentService();
    }

    public boolean enrollStudent(String studentId, String courseId) {

        System.out.println("\nStarting enrollment process...");

        // Step 1: Check student
        if (!studentService.studentExists(studentId)) {
            System.out.println("Student not found!");
            return false;
        }

        // Step 2: Check course
        if (!courseService.courseExists(courseId)) {
            System.out.println("Course not found!");
            return false;
        }

        // Step 3: Check duplicate enrollment
        if (enrollmentService.isEnrolled(studentId, courseId)) {
            System.out.println("Student is already enrolled!");
            return false;
        }

        // Step 4: Check prerequisites
        if (!prerequisiteChecker.checkPrerequisites(studentId, courseId)) {
            System.out.println("Prerequisites not completed!");
            return false;
        }

        // Step 5: Check schedule
        if (scheduleChecker.hasScheduleConflict(studentId, courseId)) {
            System.out.println("Schedule conflict detected!");
            return false;
        }

        // Step 6: Reserve a seat
        if (!courseService.reserveSeat(courseId)) {
            System.out.println("No available seats!");
            return false;
        }

        // Step 7: Save enrollment
        boolean enrolled;
        try {
            enrolled = enrollmentService.enrollStudent(studentId, courseId);
        } catch (RuntimeException e) {
            courseService.releaseSeat(courseId);
            System.out.println("Enrollment failed: " + e.getMessage());
            return false;
        }

        if (!enrolled) {
            courseService.releaseSeat(courseId);
            System.out.println("Enrollment failed!");
            return false;
        }

        // Step 8: Update schedule
        try {
            scheduleChecker.addCourseToSchedule(studentId, courseId);
        } catch (RuntimeException e) {
            enrollmentService.cancelEnrollment(studentId, courseId);
            courseService.releaseSeat(courseId);
            System.out.println("Schedule update failed!");
            return false;
        }

        System.out.println("Enrollment successful!");
        System.out.println("Student: " +
                studentService.getStudentName(studentId));
        System.out.println("Course: " + courseId);

        return true;
    }

    public boolean cancelEnrollment(String studentId, String courseId) {

        if (!enrollmentService.cancelEnrollment(studentId, courseId)) {
            System.out.println("Enrollment not found!");
            return false;
        }

        scheduleChecker.removeCourseFromSchedule(studentId, courseId);
        courseService.releaseSeat(courseId);

        System.out.println("Enrollment cancelled successfully!");
        return true;
    }
}
