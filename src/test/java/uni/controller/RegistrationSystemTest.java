package uni.controller;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import uni.entities.Course;
import uni.entities.Student;
import uni.entities.Teacher;
import uni.repository.CourseRepository;
import uni.repository.StudentRepository;
import uni.repository.TeacherRepository;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RegistrationSystemTest {
    private static CourseRepository courseRepository;
    private static StudentRepository studentRepository;
    private static RegistrationSystem registrationSystem;

    //@BeforeAll
    static void setup() {
        courseRepository = new CourseRepository(new ArrayList<>());
        studentRepository = new StudentRepository(new ArrayList<>());
        TeacherRepository teacherRepository = new TeacherRepository(new ArrayList<>());
        registrationSystem = new RegistrationSystem(studentRepository, teacherRepository, courseRepository);
        Teacher teacher = new Teacher("Ana", "Pop", 1);
        Teacher teacher1 = new Teacher("John", "Smith", 2);
        teacherRepository.save(teacher);
        teacherRepository.save(teacher1);
        Student student = new Student("Vlad", "Pop", 1);
        Student student1 = new Student("Maria", "Popa", 2);
        Student student2 = new Student("Jane", "Smith", 3);
        studentRepository.save(student);
        studentRepository.save(student1);
        studentRepository.save(student2);
        Course databases = new Course("DB", teacher,2,4);
        Course oop = new Course("OOP", teacher1, 50, 5);
        courseRepository.save(databases);
        courseRepository.save(oop);
    }

    @Test
    void register() throws Exception {
        setup();
        Course databases = courseRepository.getAll().get(0);
        Student student = studentRepository.getAll().get(0);
        Student student1 = studentRepository.getAll().get(1);
        Student student2 = studentRepository.getAll().get(2);

        assertTrue(registrationSystem.register(databases, student));
        assertFalse(registrationSystem.register(databases, student));
        assertTrue(registrationSystem.register(databases, student1));
        assertFalse(registrationSystem.register(databases, student2));
    }

    @Test
    @Description("check if an exception is thrown if the given course or student are not in the list")
    void registerNonExistingData() {
        setup();
        Teacher teacher = new Teacher("Ana", "Pop", 1);
        Student student = new Student("Vlad", "Pop", 1);
        Course databases = new Course("DB", teacher,2,4);
        try {
            registrationSystem.register(databases, student);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Test
    void retrieveCoursesWithFreePlaces() throws Exception {
        setup();
        Course databases = courseRepository.getAll().get(0);
        Course oop = courseRepository.getAll().get(1);
        Student student = studentRepository.getAll().get(0);
        Student student1 = studentRepository.getAll().get(1);
        registrationSystem.register(databases,student);
        registrationSystem.register(databases,student1);

        assertEquals(registrationSystem.retrieveCoursesWithFreePlaces().size(),1);
        assertEquals(registrationSystem.retrieveCoursesWithFreePlaces().get(0), oop);
    }

    @Test
    void retrieveStudentsEnrolledForACourse() throws Exception {
        setup();
        Course databases = courseRepository.getAll().get(0);
        Course oop = courseRepository.getAll().get(1);
        Student student = studentRepository.getAll().get(0);
        Student student1 = studentRepository.getAll().get(1);
        registrationSystem.register(databases,student);
        registrationSystem.register(databases,student1);

        assertEquals(registrationSystem.retrieveStudentsEnrolledForACourse(databases).size(),2);
        assertEquals(registrationSystem.retrieveStudentsEnrolledForACourse(oop).size(),0);
        assertEquals(registrationSystem.retrieveStudentsEnrolledForACourse(databases).get(0), student);
        assertEquals(registrationSystem.retrieveStudentsEnrolledForACourse(databases).get(1), student1);
    }

    @Test
    void getAllCourses() {
        setup();
        assertEquals(registrationSystem.getAllCourses().size(), 2);
        assertEquals(registrationSystem.getAllCourses(), courseRepository.getAll());
    }
}