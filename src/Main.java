public class Main {

    public static void main(String[] args) {

        EnrollmentFacade facade = new EnrollmentFacade();

        facade.enrollStudent("S001", "CS201");

        facade.enrollStudent("S002", "CS201");

        facade.cancelEnrollment("S001", "CS201");

        facade.enrollStudent("S002", "CS101");
    }
}
