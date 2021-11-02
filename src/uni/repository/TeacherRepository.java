package uni.repository;

import uni.entities.Student;
import uni.entities.Teacher;

import java.util.List;

public class TeacherRepository extends InMemoryRepository<Teacher>{
    public TeacherRepository(List<Teacher> repoList) {
        super(repoList);
    }

    public void deleteByID(int teacherID) {
        for (Teacher teacher : repoList)
            if (teacher.getTeacherID() == teacherID) {
                repoList.remove(teacher);
                return;
            }
    }

    @Override
    public Teacher update(Teacher entity) {
        for (Teacher teacher : repoList)
            if(teacher.equals(entity)) {
                teacher.setLastName(entity.getLastName());
                teacher.setFirstName(entity.getFirstName());
                teacher.setCourses(entity.getCourses());
                return null;
            }
        return entity;
    }
}
