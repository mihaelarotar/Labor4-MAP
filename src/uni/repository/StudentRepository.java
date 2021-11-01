package uni.repository;

import uni.entities.Student;

import java.util.List;

public class StudentRepository extends InMemoryRepository<Student>{
    public StudentRepository(List<Student> repoList) {
        super(repoList);
    }

    @Override
    public Student update(Student entity) {
        for (Student student : repoList)
            if(student.getStudentID() == entity.getStudentID()) {
                student.setTotalCredits(entity.getTotalCredits());
                student.setEnrolledCourses(entity.getEnrolledCourses());
                return null;
            }
        return entity;
    }
}
