package uni.controller;

import uni.entities.Person;
import uni.entities.Student;
import uni.repository.InMemoryRepository;
import uni.repository.StudentRepository;

import java.util.Comparator;
import java.util.List;

public class StudentController extends Controller<Student> {
    public StudentController(InMemoryRepository<Student> repository) {
        super(repository);
    }

    public void deleteByID(long studentID) {
        StudentRepository studentRepository = (StudentRepository) repository;
        studentRepository.deleteByID(studentID);
    }

    public List<Student> filterByTotalCredits(int totalCredits) {
        return filter( (student) -> student.getTotalCredits() == totalCredits);
    }

    public void sortByName() {
        Comparator<Student> compareByName = Comparator.comparing(Person::getLastName);
        sort(compareByName);
    }

    public void sortByCreditsDescending() {
        Comparator<Student> compareByCredits = Comparator.comparingInt(Student::getTotalCredits);
        sort(compareByCredits.reversed());
    }
}
