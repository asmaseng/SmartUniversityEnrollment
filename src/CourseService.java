public class CourseService {

    private int availableSeats = 2;

    public boolean checkCourse(String courseId) {
        return courseId.equals("CS101") || courseId.equals("CS201");
    }

    public boolean checkSeats() {
        return availableSeats > 0;
    }

    public void reserveSeat() {
        availableSeats--;
    }

    public void releaseSeat() {
        availableSeats++;
    }
}
