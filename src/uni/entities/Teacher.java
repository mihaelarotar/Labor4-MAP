package uni.entities;

import java.util.List;

public class Teacher extends Person{
    private List<Course> courses;

    public Teacher() {
    }

    public Teacher(String firstName, String lastName, List<Course> courses) {
        super(firstName, lastName);
        this.courses = courses;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
