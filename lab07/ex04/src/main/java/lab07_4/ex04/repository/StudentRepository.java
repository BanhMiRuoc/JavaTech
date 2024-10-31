package lab07_4.ex04.repository;

import lab07_4.ex04.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Integer> {
    List<Student> findByAgeGreaterThanEqual(int age);
    int countStudentByIelts(double ielts);
    List<Student> findByNameContaining(String name);
}
