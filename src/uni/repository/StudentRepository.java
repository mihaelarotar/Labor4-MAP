package uni.repository;

import uni.entities.Course;
import uni.entities.Student;

import java.util.List;

public class StudentRepository extends InMemoryRepository<Student>{
    public StudentRepository(List<Student> repoList) {
        super(repoList);
    }

    public void deleteByID(long studentID) {
        for (Student student : repoList)
            if (student.getStudentID() == studentID) {
                repoList.remove(student);
                return;
            }
    }

    @Override
    public Student update(Student entity) {
        for (Student student : repoList)
            if(student.getStudentID() == entity.getStudentID()) {
                student.setLastName(entity.getLastName());
                student.setFirstName(entity.getFirstName());
                student.setTotalCredits(entity.getTotalCredits());
                student.setEnrolledCourses(entity.getEnrolledCourses());
                return null;
            }
        return entity;
    }
}
