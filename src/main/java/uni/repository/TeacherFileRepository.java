package uni.repository;

import uni.entities.Teacher;

public class TeacherFileRepository extends TeacherRepository implements FileRepository<Teacher> {

    public TeacherFileRepository() {
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
    public Teacher save(Teacher entity) {
        return super.save(entity);
    }

    /**
     * {@inheritDoc}
     *
     * @param entity
     */
    @Override
    public Teacher delete(Teacher entity) {
        return super.delete(entity);
    }

    /**
     * deletes the teacher with the given ID from the list
     *
     * @param teacherID int, representing the ID of the teacher to be removed
     */
    @Override
    public void deleteByID(int teacherID) {
        super.deleteByID(teacherID);
    }

    /**
     * updates a teacher in list
     *
     * @param entity entity must not be null
     * @return null - if the entity is updated,
     * otherwise returns the entity (if the entity with the given ID does not exist)
     */
    @Override
    public Teacher update(Teacher entity) {
        return super.update(entity);
    }
}
