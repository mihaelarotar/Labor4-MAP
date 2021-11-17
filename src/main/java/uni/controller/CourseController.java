package uni.controller;

import uni.entities.Course;
import uni.repository.CourseRepository;

import java.util.Comparator;
import java.util.List;


public class CourseController extends Controller<Course> {

    public CourseController(CourseRepository courseRepository) {
        super(courseRepository);
    }

    public void deleteByName(String name) {
        CourseRepository courseRepository = (CourseRepository) repository;
        courseRepository.deleteByName(name);
    }

    public List<Course> filterByCredits(int credits) {
        return filter( (course) -> course.getCredits() == credits);
    }

    public void sortByName() {
        Comparator<Course> compareByName = Comparator.comparing(Course::getName);
        sort(compareByName);
    }

    public void sortByCredits() {
        Comparator<Course> compareByCredits = Comparator.comparingInt(Course::getCredits);
        sort(compareByCredits);
    }
}
