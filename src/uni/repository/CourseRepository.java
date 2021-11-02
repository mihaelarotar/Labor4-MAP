package uni.repository;

import uni.entities.Course;

import java.util.List;

public class CourseRepository extends InMemoryRepository<Course>{
    public CourseRepository(List<Course> repoList) {
        super(repoList);
    }

    public void deleteByName(String name){
        for (Course course : repoList)
            if (course.getName().equals(name)) {
                repoList.remove(course);
                return;
            }
    }

    @Override
    public Course save(Course entity) {
        return super.save(entity);
    }

    @Override
    public Course update(Course entity) {
        for (Course course : repoList)
            if (course.equals(entity)) {
                course.setTeacher(entity.getTeacher());
                course.setCredits(entity.getCredits());
                course.setMaxEnrollment(entity.getMaxEnrollment());
                course.setStudentsEnrolled(entity.getStudentsEnrolled());
                return null;
            }
    return entity;
    }


}
