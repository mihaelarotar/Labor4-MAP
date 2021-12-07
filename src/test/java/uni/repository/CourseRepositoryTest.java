package uni.repository;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import uni.entities.Course;
import uni.exceptions.InvalidDataException;


import static org.junit.jupiter.api.Assertions.*;

class CourseRepositoryTest {
    @Test
    void findIndex() {
        CourseRepository courseRepository = new CourseRepository();
        Course oop = new Course("OOP", 1, 50,  5);
        courseRepository.save(oop);
        assertEquals(courseRepository.findIndex(oop),0);
        Course databases = new Course("DB", 3,30,4);
        courseRepository.save(databases);
        assertEquals(courseRepository.findIndex(databases),1);
    }

    @Test
    void save() {
        CourseRepository courseRepository = new CourseRepository();
        assertEquals(courseRepository.getAll().size(),0);
        courseRepository.save(new Course("OOP", 1, 50,  5));
        Course databases = new Course("DB", 3,30,4);
        assertEquals(courseRepository.save(databases), databases);
        assertEquals(courseRepository.getAll().size(),2);
    }


    @Test
    @Description("test if a course with the same name as an existing course can be added (it cannot)")
    void saveExistingCourse() {
        CourseRepository courseRepository = new CourseRepository();
        Course databases = new Course("DB",3,30,4);
        courseRepository.save(databases);
        assertNull(courseRepository.save(databases));
        Course databases1 = new Course("DB",3,60,4);
        assertNull(courseRepository.save(databases1));
    }

    @Test
    @Description("checks if an exception is thrown when trying to add an invalid object")
    void validateName() {
        assertThrows(InvalidDataException.class, () -> new Course("", 3, 80, 6));
    }

    @Test
    @Description("checks if an exception is thrown when trying to add an invalid object")
    void validateValues() {
        assertThrows(InvalidDataException.class, () -> new Course("DB", 3, -80, -6));
    }

    @Test
    void delete() {
        CourseRepository courseRepository = new CourseRepository();
        Course databases = new Course("DB", 3,30,4);
        courseRepository.save(databases);
        assertEquals(courseRepository.getAll().size(),1);
        assertEquals(courseRepository.delete(databases), databases);
        assertEquals(courseRepository.getAll().size(),0);
        assertNull(courseRepository.delete(databases));
    }


    @Test
    void update() {
        CourseRepository courseRepository = new CourseRepository();
        Course databases = new Course("DB", 3,30,4);
        courseRepository.save(databases);
        Course databases1 = new Course("DB", 2,90,4);
        assertNull(courseRepository.update(databases1));
        assertEquals(courseRepository.getAll().get(0).getMaxEnrollment(), 90);
    }

    @Test
    void deleteByName() {
        CourseRepository courseRepository = new CourseRepository();
        courseRepository.save(new Course("OOP", 1, 50, 5));
        courseRepository.deleteByName("OOP");
        assertEquals(courseRepository.getAll().size(),0);
    }

}