package Backend;

import java.util.ArrayList;

public class Student extends User {
    private ArrayList<String> enrolledCourses;
    private ArrayList<StudentCourseProgress> coursesProgress;

    public Student(String userName, int userId, String email, String passwordHash) {
        super(userName, userId, email, passwordHash, "student");
        this.enrolledCourses = new ArrayList<>();
        this.coursesProgress = new ArrayList<>();
    }
    public Student(String userName, String email, String passwordHash) {
        super(userName, email, passwordHash, "student");
        this.enrolledCourses = new ArrayList<>();
        this.coursesProgress = new ArrayList<>();
    }
    // Enroll student to a course
    public void addCourse(String courseId) {
        if (!enrolledCourses.contains(courseId)) {
            enrolledCourses.add(courseId);
            coursesProgress.add(new StudentCourseProgress(courseId));
        }
    }

    // Add full progress (used by JSON loader)
    public void addProgress(String courseId, ArrayList<String> completedLessons) {
        
     
        
        StudentCourseProgress p = new StudentCourseProgress(courseId);
        p.completedLessons = completedLessons;
        coursesProgress.add(p);
    }

    // Mark lesson as completed
    public void addLessonCompleted(String courseId, String lessonId) {
        for (StudentCourseProgress p : coursesProgress) {
            if (p.courseId.equals(courseId) && !p.completedLessons.contains(lessonId)) {
                p.completedLessons.add(lessonId);
                break;
            }
        }
    }
    
     public boolean isLessonCompleted(String courseId, String lessonId) {
    for (StudentCourseProgress p : coursesProgress) {
        if (p.courseId.equals(courseId) && p.completedLessons.contains(lessonId)) {
            return true;
        }
    }
    return false;
}

    public ArrayList<String> getEnrolledCourses() {
        return enrolledCourses;
    }

    public ArrayList<StudentCourseProgress> getCoursesProgress() {
        return coursesProgress;
    }
    public void setEnrolledCourses(ArrayList<String> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }
    public void setCoursesProgress(ArrayList<StudentCourseProgress> coursesProgress) {
        this.coursesProgress = coursesProgress;
    }

}