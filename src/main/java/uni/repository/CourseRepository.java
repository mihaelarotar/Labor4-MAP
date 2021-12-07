package uni.repository;

import uni.entities.Course;
import uni.entities.Student;



public class CourseRepository extends InMemoryRepository<Course> {
    public CourseRepository() {
        super();
    }


    /**
     * deletes the course with the given name from the list, as well from the teacher's list of courses
     * and the students' lists of enrolled courses
     * @param name string, representing the name of the course to be deleted
     */
    public void deleteByName(String name){
        for (Course course : repoList)
            if (course.getName().equals(name)) {
                for (Student student : course.getStudentsEnrolled()) {
                    student.removeCourseFromEnrolledCourses(course);
                }
                repoList.remove(course);
                return;
            }
    }


    /**
     * deletes the course with the given name from the list, as well from the teacher's list of courses
     * and the students' lists of enrolled courses
     * @param course must not be null
     * @return the removed entity or null if there is no such entity
     */
    @Override
    public Course delete(Course course) {
        for (Student student : course.getStudentsEnrolled()) {
            student.removeCourseFromEnrolledCourses(course);
        }
        return super.delete(course);
    }

    /**
     * updates given course in list
     * @param entity entity must not be null
     * @return null - if the entity is updated, otherwise returns the entity (if this entity does not exist)
     */
    @Override
    public Course update(Course entity) {
        for (Course course : repoList)
            if (course.equals(entity)) {
                course.setTeacherID(entity.getTeacherID());
                course.setCredits(entity.getCredits());
                course.setMaxEnrollment(entity.getMaxEnrollment());
                course.setStudentsEnrolled(entity.getStudentsEnrolled());
                return null;
            }
    return entity;
    }

    /**
     * returns the course with the given name
     * @param courseName string, representing the title of the course to be returned
     * @return the course with the given name
     */
    public Course findByName(String courseName) {
        return repoList.stream()
                .filter(course -> course.getName().equals(courseName))
                .findFirst()
                .orElseThrow();
    }

}
