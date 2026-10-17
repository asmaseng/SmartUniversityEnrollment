public class Main {

    public static void main(String[] args) {

        EnrollmentFacade enrollmentFacade = new EnrollmentFacade();

        System.out.println("TEST 1: Successful Enrollment");
        enrollmentFacade.enrollStudent("S001", "CS201");

        System.out.println("\nTEST 2: Missing Prerequisites");
        enrollmentFacade.enrollStudent("S002", "CS201");

        System.out.println("\nTEST 3: Schedule Conflict");
        enrollmentFacade.enrollStudent("S001", "MATH101");

        System.out.println("\nTEST 4: Duplicate Enrollment");
        enrollmentFacade.enrollStudent("S001", "CS201");

        System.out.println("\nTEST 5: Student Not Found");
        enrollmentFacade.enrollStudent("S999", "CS101");

        System.out.println("\nTEST 6: Cancel Enrollment");
        enrollmentFacade.cancelEnrollment("S001", "CS201");

        System.out.println("\nTEST 7: Enrollment After Cancellation");
        enrollmentFacade.enrollStudent("S001", "MATH101");
    }
}
