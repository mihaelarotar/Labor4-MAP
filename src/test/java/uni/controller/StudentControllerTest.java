package uni.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uni.entities.Student;
import uni.exceptions.ExceededValueException;
import uni.repository.StudentRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentControllerTest {

    private StudentController studentController;

    @BeforeEach
    void setup() {
        StudentRepository studentRepository = new StudentRepository();
        studentController = new StudentController(studentRepository);
        Student student = new Student("Maria", "Pop", 100);
        Student student1 = new Student("Vlad", "Popa", 101);
        Student student2 = new Student("Marian", "Popa", 102);
        Student student3 = new Student("Vlad", "Apopei", 104);
        Student student4 = new Student("Jane", "Doe", 105);

        try {
            student.setTotalCredits(30);
            student1.setTotalCredits(25);
            student4.setTotalCredits(10);
            student2.setTotalCredits(25);
        } catch (ExceededValueException exception) {
            System.out.println(exception.getMessage());
        }

        studentController.add(student);
        studentController.add(student1);
        studentController.add(student2);
        studentController.add(student3);
        studentController.add(student4);

    }

    @Test
    void filterByTotalCredits() {
        List<Student> filteredStudents = studentController.filterByTotalCredits(25);
        assertEquals(filteredStudents, new ArrayList<>(Arrays.asList(studentController.findByID(101), studentController.findByID(102))));
    }

    @Test
    void sortByName() {
        studentController.sortByName();
        assertEquals(studentController.getAll(), new ArrayList<>(Arrays.asList(studentController.findByID(104),
                studentController.findByID(105), studentController.findByID(100),
                studentController.findByID(102), studentController.findByID(101))));
    }

    @Test
    void sortByCreditsDescending() {
        studentController.sortByCreditsDescending();
        assertEquals(studentController.getAll(), new ArrayList<>(Arrays.asList(studentController.findByID(100),
                studentController.findByID(101), studentController.findByID(102),
                studentController.findByID(105), studentController.findByID(104))));
    }
}