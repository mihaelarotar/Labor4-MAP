package uni;

import uni.controller.CourseController;
import uni.controller.RegistrationSystem;
import uni.controller.StudentController;
import uni.entities.Course;
import uni.entities.Student;
import uni.entities.Teacher;
import uni.repository.CourseRepository;
import uni.repository.StudentRepository;
import uni.repository.TeacherRepository;


public class Main {

    public static void main(String[] args) throws Exception {
        StudentRepository studentRepository = new StudentRepository();
        CourseRepository courseRepository = new CourseRepository();
        TeacherRepository teacherRepository = new TeacherRepository();
        RegistrationSystem myRegistrationSystem = new RegistrationSystem(studentRepository, teacherRepository, courseRepository);
        Student student = new Student("Vlad", "Popa", 2);
        studentRepository.save(student);
        Student student1 = new Student("Vlad", "Apopei", 3);
        studentRepository.save(student1);
        Teacher teacher = new Teacher("John", "Smith", 3);
        Course databases = new Course("DB", teacher,30,4);
        System.out.println(teacher);

        courseRepository.save(databases);
        System.out.println(myRegistrationSystem.register(databases, student));
        System.out.println(databases);

        System.out.println(teacher);

        CourseController courseController = new CourseController(courseRepository);

        System.out.println("-----------------------");
        for (Course course : courseController.getAll()) {
            System.out.println(course);
        }
        //courseController.deleteByName("DB");
        System.out.println("-----------------------");
        for (Course course : courseController.getAll()) {
            System.out.println(course);
        }

        for (Course course : courseController.filterByCredits(5)) {
            System.out.println(course);
        }
        System.out.println("-----------------------");

        StudentController studentController = new StudentController(studentRepository);
        for (Student myStudent : studentController.getAll()) {
            System.out.println(myStudent);
        }
        studentController.sortByCreditsDescending();
        for (Student myStudent : studentController.getAll()) {
            System.out.println(myStudent);
        }
    }
}
