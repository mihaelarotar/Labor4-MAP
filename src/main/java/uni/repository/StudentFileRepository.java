package uni.repository;

import uni.entities.Student;

public class StudentFileRepository extends StudentRepository implements FileRepository<Student> {
    public StudentFileRepository() {
        super();
        readFromFile();
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

    /**
     * {@inheritDoc}
     *
     * @param entity
     */
    @Override
    public Student save(Student entity) {
        return super.save(entity);
    }

    /**
     * {@inheritDoc}
     *
     * @param entity
     */
    @Override
    public Student delete(Student entity) {
        return super.delete(entity);
    }

    /**
     * deletes the student with the given ID from the list
     *
     * @param studentID long, representing the ID of the student to be removed
     */
    @Override
    public void deleteByID(long studentID) {
        super.deleteByID(studentID);
    }

    /**
     * updates a student in list
     *
     * @param entity entity must not be null
     * @return null - if the entity is updated,
     * otherwise returns the entity (if the entity with the given ID does not exist)
     */
    @Override
    public Student update(Student entity) {
        return super.update(entity);
    }
}
