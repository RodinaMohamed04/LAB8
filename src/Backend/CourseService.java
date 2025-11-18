package Backend;
import java.util.ArrayList;
public class CourseService {
    private ArrayList<Course> courses;
    public CourseService() {
        courses = JasonDataBaseManager.readCourse();
    }
    private void saveCourses() {
        JasonDataBaseManager.saveCourse(courses);
        if (courses == null) courses = new ArrayList<>();
    }
    
    private void saveChanges(){
        JasonDataBaseManager.saveCourse(courses);
    }

    public void addCourse(Course c) {
        courses.add(c);
        saveCourses();
    }
    public Course getCourseById(String courseId) {
        for (Course c : courses) {
            if (c.getCourseId().equals(courseId)) {
                return c;
            }
        }
        return null;
    }
    public ArrayList<Course> getAllCourses() {
        return courses;
    }
    public boolean removeCourse(String courseId) {
    Course c = getCourseById(courseId);
    if (c != null) {
        courses.remove(c);
        saveCourses();
        return true;
    }
    return false;
}
    /*public void removeCourse(String courseId) {
        Course c = getCourseById(courseId);
        if (c != null) {
            courses.remove(c);
            saveCourses();
        }
    }*/
   /* public void updateCourse(String courseId, String name, String description) {
        Course c = getCourseById(courseId);
        if (c != null) {
            c.setCourseName(name);
            c.setCourseDescription(description);
            saveCourses();
        }
    }*/
    public void updateCourse(String oldCourseId, String newName, String newCourseId) {
    Course c = getCourseById(oldCourseId);
    if (c != null) {
        c.setCourseId(newCourseId);     
        c.setCourseName(newName);
        saveCourses();
    }
}

    public  void addCourse(Course c,ArrayList<Lesson> lessons,ArrayList<Student> students){
        c.setLessons(lessons);
        c.setStudents(students);
        courses.add(c);
        saveCourses();
    }
    public ArrayList<Course> displayCourses() {
        return new ArrayList<>(courses);
}
    public void addLessonToCourse(String courseId, Lesson lesson) {
        Course c = getCourseById(courseId);
        if (c != null) {
            c.getLessons().add(lesson);
            saveCourses();
        }
    }

    public void removeLessonFromCourse(String courseId, String lessonId) {
        Course c = getCourseById(courseId);
        if (c != null) {
            c.getLessons().removeIf(l -> l.getLessonId().equals(lessonId));
            saveCourses();
        }
    }
    public void addStudentToCourse(String courseId, Student student) {
        Course c = getCourseById(courseId);
        if (c != null && !c.getStudents().contains(student)) {
            c.getStudents().add(student);
            saveCourses();
        }
    }

    public void removeStudentFromCourse(String courseId, int studentId) {
        Course c = getCourseById(courseId);
        if (c != null) {
            c.getStudents().removeIf(s -> s.getUserId() == studentId);
            saveCourses();
        }
    }
    public ArrayList<Course> getInstructorCourses(int instructorId) {
    ArrayList<Course> result = new ArrayList<>();
    for (Course c : courses) {
        if (c.getInstructorId() == instructorId) {
            result.add(c);
        }
    }
    return result;
}
}

