package uni.repository;

import org.junit.jupiter.api.Test;
import uni.entities.Course;
import uni.entities.Teacher;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CourseRepositoryTest {

    @Test
    void save() {
        CourseRepository courseRepository = new CourseRepository(new ArrayList<>());
        assertEquals(courseRepository.getAll().size(),0);
        courseRepository.save(new Course("OOP", new Teacher("Ana", "Pop", null, 1), 50, null, 5));
        assertEquals(courseRepository.getAll().size(),1);
        try {
            Course course = new Course("",null,50,null,5);
            courseRepository.save(course);
        } catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
        }
        assertEquals(courseRepository.getAll().size(),1);
        try {
            Course course = new Course("DB",null,50,null,-5);
            courseRepository.save(course);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        assertEquals(courseRepository.getAll().size(),1);
        Course databases = new Course("DB",null,30,null,4);
        assertEquals(courseRepository.save(databases), databases);
        assertEquals(courseRepository.getAll().size(),2);
        assertNull(courseRepository.save(databases));
        assertEquals(courseRepository.getAll().size(),2);

        // test if a course with the same name as an existing course can be added (it cannot)
        Course databases1 = new Course("DB",null,60,null,4);
        assertNull(courseRepository.save(databases1));
    }

    @Test
    void delete() {
        CourseRepository courseRepository = new CourseRepository(new ArrayList<>());
        assertEquals(courseRepository.getAll().size(),0);
        Course oop = new Course("OOP", new Teacher("Ana", "Pop", null, 1), 50, null, 5);
        courseRepository.save(oop);
        assertEquals(courseRepository.getAll().size(),1);
        Course databases = new Course("DB",null,30,null,4);
        courseRepository.save(databases);
        assertEquals(courseRepository.getAll().size(),2);
        assertEquals(courseRepository.delete(databases), databases);
        assertEquals(courseRepository.getAll().size(),1);
        assertNull(courseRepository.delete(databases));
        assertEquals(courseRepository.delete(oop),oop);
        assertEquals(courseRepository.getAll().size(),0);
    }

    @Test
    void update() {
        CourseRepository courseRepository = new CourseRepository(new ArrayList<>());
        assertEquals(courseRepository.getAll().size(),0);
        Course databases = new Course("DB",null,30,null,4);
        courseRepository.save(databases);
        assertEquals(courseRepository.getAll().size(),1);
        Course databases1 = new Course("DB", new Teacher("Ion", "Pop", null, 2),90,null,4);
        assertNull(courseRepository.update(databases1));
        assertEquals(courseRepository.getAll().size(),1);
        assertEquals(courseRepository.getAll().get(0).getTeacher().getLastName(), "Pop");
        assertEquals(courseRepository.getAll().get(0).getMaxEnrollment(), 90);
    }

    @Test
    void deleteByName() {
        CourseRepository courseRepository = new CourseRepository(new ArrayList<>());
        assertEquals(courseRepository.getAll().size(),0);
        courseRepository.save(new Course("OOP", new Teacher("Ana", "Pop",null,1), 50, null, 5));
        assertEquals(courseRepository.getAll().size(),1);
        courseRepository.deleteByName("OOP");
        assertEquals(courseRepository.getAll().size(),0);
    }
}