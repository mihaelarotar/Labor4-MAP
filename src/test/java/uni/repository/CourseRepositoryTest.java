package uni.repository;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import uni.entities.Course;
import uni.entities.Teacher;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CourseRepositoryTest {
    @Test
    void findIndex() {
        CourseRepository courseRepository = new CourseRepository(new ArrayList<>());
        Course oop = new Course("OOP", new Teacher("Ana", "Pop", 1), 50,  5);
        courseRepository.save(oop);
        assertEquals(courseRepository.findIndex(oop),0);
        Course databases = new Course("DB", new Teacher("John", "Smith", 3),30,4);
        courseRepository.save(databases);
        assertEquals(courseRepository.findIndex(databases),1);
    }

    @Test
    void save() {
        CourseRepository courseRepository = new CourseRepository(new ArrayList<>());
        assertEquals(courseRepository.getAll().size(),0);
        courseRepository.save(new Course("OOP", new Teacher("Ana", "Pop", 1), 50,  5));
        assertEquals(courseRepository.getAll().size(),1);
        Teacher teacher = new Teacher("John", "Smith", 3);
        Course databases = new Course("DB", teacher,30,4);
        assertEquals(courseRepository.save(databases), databases);
        assertEquals(courseRepository.getAll().size(),2);
        assert(teacher.getCourses().contains(databases));
    }

    @Test
    @Description("test if a course with the same name as an existing course can be added (it cannot)")
    void saveExistingCourse() {
        CourseRepository courseRepository = new CourseRepository(new ArrayList<>());
        Course databases = new Course("DB",new Teacher("John", "Smith", 3),30,4);
        assertEquals(courseRepository.save(databases), databases);
        assertNull(courseRepository.save(databases));
        assertEquals(courseRepository.getAll().size(),1);
        Course databases1 = new Course("DB",new Teacher("John", "Smith", 3),60,4);
        assertNull(courseRepository.save(databases1));
    }

    @Test
    @Description("checks if an exception is thrown when trying to add an invalid object")
    void saveAndValidate() {
        CourseRepository courseRepository = new CourseRepository(new ArrayList<>());
        try {
            Course course = new Course("",new Teacher("John", "Smith", 3),50,5);
            courseRepository.save(course);
        } catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
        }
        assertEquals(courseRepository.getAll().size(),0);
        try {
            Course course = new Course("DB",new Teacher("John", "Smith", 3),50,-5);
            courseRepository.save(course);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        assertEquals(courseRepository.getAll().size(),0);
    }

    @Test
    void delete() {
        CourseRepository courseRepository = new CourseRepository(new ArrayList<>());
        Teacher teacher = new Teacher("John", "Smith", 3);
        Course databases = new Course("DB", teacher,30,4);
        courseRepository.save(databases);
        assertEquals(courseRepository.getAll().size(),1);
        assertEquals(courseRepository.delete(databases), databases);
        assertEquals(courseRepository.getAll().size(),0);
        assertNull(courseRepository.delete(databases));
        assertFalse(teacher.getCourses().contains(databases));
    }

    @Test
    void update() {
        CourseRepository courseRepository = new CourseRepository(new ArrayList<>());
        assertEquals(courseRepository.getAll().size(),0);
        Course databases = new Course("DB", new Teacher("John", "Smith", 3),30,4);
        courseRepository.save(databases);
        assertEquals(courseRepository.getAll().size(),1);
        Course databases1 = new Course("DB", new Teacher("Ion", "Pop", 2),90,4);
        assertNull(courseRepository.update(databases1));
        assertEquals(courseRepository.getAll().size(),1);
        assertEquals(courseRepository.getAll().get(0).getTeacher().getLastName(), "Pop");
        assertEquals(courseRepository.getAll().get(0).getMaxEnrollment(), 90);
    }

    @Test
    void deleteByName() {
        CourseRepository courseRepository = new CourseRepository(new ArrayList<>());
        assertEquals(courseRepository.getAll().size(),0);
        courseRepository.save(new Course("OOP", new Teacher("Ana", "Pop",1), 50, 5));
        assertEquals(courseRepository.getAll().size(),1);
        courseRepository.deleteByName("OOP");
        assertEquals(courseRepository.getAll().size(),0);
    }

}