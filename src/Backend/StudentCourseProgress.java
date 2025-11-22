package Backend;

import java.util.ArrayList;

// Class to track progress per course without Map
public class StudentCourseProgress {


    String courseId;
    ArrayList<String> completedLessons;

    public StudentCourseProgress(String courseId) {
        this.courseId = courseId;
        this.completedLessons = new ArrayList<>();
    }


}
