package uni.entities;

import java.util.List;
import java.util.Objects;

public class Student extends Person{
    private long studentID;
    private int totalCredits;
    private List<Course> enrolledCourses;

    public Student() {
    }

    public Student(String firstName, String lastName, long studentID, int totalCredits, List<Course> enrolledCourses) {
        super(firstName, lastName);
        this.studentID = studentID;
        this.totalCredits = totalCredits;
        this.enrolledCourses = enrolledCourses;
        validate();
    }

    public long getStudentID() {
        return studentID;
    }

    public void setStudentID(long studentID) {
        this.studentID = studentID;
    }

    public int getTotalCredits() {
        return totalCredits;
    }

    public void setTotalCredits(int totalCredits) {
        this.totalCredits = totalCredits;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(List<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    private void validate() {
        if (studentID <= 0) {
            throw new IllegalArgumentException("Invalid ID");
        }
        if (totalCredits < 0) {
            throw new IllegalArgumentException("Value cannot be negative");
        } else if (totalCredits > 30) {
            throw new IllegalArgumentException("Total number of credits must be smaller than 30");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentID == student.studentID;
    }

}
