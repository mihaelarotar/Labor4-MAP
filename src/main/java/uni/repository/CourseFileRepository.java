package uni.repository;

import uni.entities.Course;

public class CourseFileRepository extends CourseRepository implements FileRepository<Course> {

    public CourseFileRepository() {
        super();
        readFromFile();
    }

    /**
     * deletes the course with the given name from the list, as well from the teacher's list of courses
     * and the students' lists of enrolled courses
     *
     * @param name string, representing the name of the course to be deleted
     */
    @Override
    public void deleteByName(String name) {
        super.deleteByName(name);
    }

    /**
     * adds a new course to the list of courses, as well to the teacher's list of courses
     *
     * @param entity entity must be not null
     * @return the entity - if the given entity was created successfully, otherwise returns null (if the entity already exists)
     */
    @Override
    public Course save(Course entity) {
        return super.save(entity);
    }

    /**
     * deletes the course with the given name from the list, as well from the teacher's list of courses
     * and the students' lists of enrolled courses
     *
     * @param course must not be null
     * @return the removed entity or null if there is no such entity
     */
    @Override
    public Course delete(Course course) {
        return super.delete(course);
    }

    /**
     * updates given course in list
     *
     * @param entity entity must not be null
     * @return null - if the entity is updated, otherwise returns the entity (if this entity does not exist)
     */
    @Override
    public Course update(Course entity) {
        return super.update(entity);
    }

    /**
     * reads data from file
     */
    @Override
    public void readFromFile() {

    }

    /**
     * writes data to file
     */
    @Override
    public void writeToFile() {

    }
}
