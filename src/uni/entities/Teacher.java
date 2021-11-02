package uni.entities;

import java.util.List;
import java.util.Objects;

public class Teacher extends Person{
    private int teacherID;
    private List<Course> courses;

    public Teacher() {
    }

    public Teacher(String firstName, String lastName, List<Course> courses, int teacherID) {
        super(firstName, lastName);
        this.teacherID = teacherID;
        this.courses = courses;
        validate();
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return teacherID == teacher.teacherID;
    }

    private void validate() {
        if(teacherID <= 0) {
            throw new IllegalArgumentException("Invalid ID");
        }
    }
}
