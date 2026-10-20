public class ScheduleChecker {

    public boolean checkSchedule(String studentId, String courseId) {
        if (studentId.equals("S002") && courseId.equals("CS101")) {
            return false;
        }

        return true;
    }
}
