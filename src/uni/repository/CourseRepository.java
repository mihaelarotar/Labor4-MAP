package uni.repository;

import uni.entities.Course;

import java.util.List;

public class CourseRepository extends InMemoryRepository<Course>{
    public CourseRepository(List<Course> repoList) {
        super(repoList);
    }

    @Override
    public Course update(Course entity) {
        for (Course course : repoList)
            if (course.getName().equals(entity.getName())) {
                course.setTeacher(entity.getTeacher());
                course.setCredits(entity.getCredits());
                course.setMaxEnrollment(entity.getMaxEnrollment());
                course.setStudentsEnrolled(entity.getStudentsEnrolled());
                return null;
            }
    return entity;
    }


}
