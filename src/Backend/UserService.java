package Backend;
import java.util.ArrayList;
public class UserService {
    private ArrayList<User> users;
    public UserService() {
        users= JasonDataBaseManager.read();
    }
    private void saveUsers() {
        JasonDataBaseManager.save(users);
    }
public void addUser(User u) {
    users.add(u);
    saveUsers();
}
 public User getUserbyID(int id) {
        for (User u : users) {
            if (u.getUserId() == id) {
                return u;
            }
        }
        return null;
    }
    public ArrayList<User> getAllUsers() {
        return users;
    }

public void enrollStudent(int id,String courseID) {
    User u=getUserbyID(id);
    if(u instanceof Student s) {
        s.addCourse(courseID);
        saveUsers();
    }}
public void markLessonCompleted(int id, String courseID, String lessonID) {
        User u = getUserbyID(id);
        if (u instanceof Student s) {
            s.addLessonCompleted(courseID, lessonID);
            saveUsers();
        }
    }
    public void addCourseToInstructor(int instructorId, String courseId) {
        User u = getUserbyID(instructorId);
        if (u instanceof Instructor i) {
            i.addCreatedCourseId(courseId);
            saveUsers();
        }
    }
     public ArrayList<String> displayEnrolledCourses(int Id) {
        User u = getUserbyID(Id);
        if (u instanceof Student s) {
            return s.getEnrolledCourses();
        }
        return new ArrayList<>();
    }
}
