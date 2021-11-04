package uni.repository;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import uni.entities.Teacher;

import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.*;

class TeacherRepositoryTest {

    @Test
    void save() {
        TeacherRepository teacherRepository = new TeacherRepository(new ArrayList<>());
        assertEquals(teacherRepository.getAll().size(),0);
        teacherRepository.save(new Teacher("Ana", "Pop", 1));
        assertEquals(teacherRepository.getAll().size(),1);

        Teacher teacher = new Teacher("John", "Smith", 3);
        assertEquals(teacherRepository.save(teacher), teacher);
        assertEquals(teacherRepository.getAll().size(),2);
        assertNull(teacherRepository.save(teacher));
        assertEquals(teacherRepository.getAll().size(),2);
    }

    @Test
    @Description("checks if an exception is thrown when trying to add an invalid object")
    void saveAndValidate() {
        TeacherRepository teacherRepository = new TeacherRepository(new ArrayList<>());
        try {
            Teacher teacher = new Teacher("", "Smith", 3);
            teacherRepository.save(teacher);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        try {
            Teacher teacher = new Teacher("John", "Smith", -3);
            teacherRepository.save(teacher);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        assertEquals(teacherRepository.getAll().size(),0);
    }

    @Test
    void delete() {
        TeacherRepository teacherRepository = new TeacherRepository(new ArrayList<>());
        assertEquals(teacherRepository.getAll().size(),0);
        Teacher teacher = new Teacher("John", "Smith", 3);
        teacherRepository.save(teacher);
        assertEquals(teacherRepository.getAll().size(),1);
        Teacher teacher1 = new Teacher("Ana", "Pop", 1);
        teacherRepository.save(teacher1);
        assertEquals(teacherRepository.getAll().size(),2);
        assertEquals(teacherRepository.delete(teacher1), teacher1);
        assertEquals(teacherRepository.getAll().size(),1);
        assertNull(teacherRepository.delete(teacher1));
        assertEquals(teacherRepository.delete(teacher),teacher);
        assertEquals(teacherRepository.getAll().size(),0);
    }

    @Test
    void update() {
        TeacherRepository teacherRepository = new TeacherRepository(new ArrayList<>());
        assertEquals(teacherRepository.getAll().size(),0);
        Teacher teacher = new Teacher("John", "Smith", 3);
        teacherRepository.save(teacher);
        assertEquals(teacherRepository.getAll().size(),1);
        Teacher teacher1 = new Teacher("John", "Brown", 3);
        assertNull(teacherRepository.update(teacher1));
        assertEquals(teacherRepository.getAll().size(),1);
        assertEquals(teacherRepository.getAll().get(0).getLastName(), "Brown");
    }

    @Test
    void deleteByID() {
        TeacherRepository teacherRepository = new TeacherRepository(new ArrayList<>());
        assertEquals(teacherRepository.getAll().size(),0);
        teacherRepository.save(new Teacher("John", "Smith", 3));
        assertEquals(teacherRepository.getAll().size(),1);
        teacherRepository.deleteByID(3);
        assertEquals(teacherRepository.getAll().size(),0);
    }
}