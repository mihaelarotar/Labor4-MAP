package uni.repository;

import org.junit.jupiter.api.Test;
import uni.entities.Student;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StudentRepositoryTest {

    @Test
    void save() {
        StudentRepository studentRepository = new StudentRepository(new ArrayList<>());
        assertEquals(studentRepository.getAll().size(),0);
        studentRepository.save(new Student("Maria", "Ionescu", 123456, 25,null));
        assertEquals(studentRepository.getAll().size(),1);
        try {
            Student student = new Student("Maria", "Ionescu", 123456, 31, null);
            studentRepository.save(student);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        assertEquals(studentRepository.getAll().size(),1);

        Student student = new Student("Vlad", "Popa", 2, 0,null);
        assertEquals(studentRepository.save(student), student);
        assertEquals(studentRepository.getAll().size(),2);
        Student student1 = new Student("Vlad", "Popa", 2, 12,null);
        assertNull(studentRepository.save(student1));
        assertEquals(studentRepository.getAll().size(),2);
    }

    @Test
    void delete() {
        StudentRepository studentRepository = new StudentRepository(new ArrayList<>());
        assertEquals(studentRepository.getAll().size(),0);
        Student student = new Student("Vlad", "Popa", 2, 0,null);
        studentRepository.save(student);
        assertEquals(studentRepository.getAll().size(),1);
        Student student1 = new Student("Maria", "Ionescu", 123456, 30, null);
        studentRepository.save(student1);
        assertEquals(studentRepository.getAll().size(),2);
        assertEquals(studentRepository.delete(student1), student1);
        assertEquals(studentRepository.getAll().size(),1);
        assertNull(studentRepository.delete(student1));
        assertEquals(studentRepository.delete(student), student);
        assertEquals(studentRepository.getAll().size(),0);
    }

    @Test
    void deleteByID() {
        StudentRepository studentRepository = new StudentRepository(new ArrayList<>());
        assertEquals(studentRepository.getAll().size(),0);
        studentRepository.save(new Student("Maria", "Ionescu", 123456, 25,null));
        assertEquals(studentRepository.getAll().size(),1);
        studentRepository.deleteByID(123456);
        assertEquals(studentRepository.getAll().size(),0);
    }

    @Test
    void update() {
        StudentRepository studentRepository = new StudentRepository(new ArrayList<>());
        assertEquals(studentRepository.getAll().size(),0);
        Student student = new Student("Vlad", "Popa", 2, 0,null);
        studentRepository.save(student);
        assertEquals(studentRepository.getAll().size(),1);
        Student student1 = new Student("Ana", "Popa", 2, 10, null);
        assertNull(studentRepository.update(student1));
        assertEquals(studentRepository.getAll().size(), 1);
        assertEquals(studentRepository.getAll().get(0).getFirstName(), "Ana");
        assertEquals(studentRepository.getAll().get(0).getTotalCredits(), 10);
    }
}