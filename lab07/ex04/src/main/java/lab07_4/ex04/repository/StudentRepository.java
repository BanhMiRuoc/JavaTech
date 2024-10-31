package lab07_4.ex04.repository;

import lab07_4.ex04.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Integer> {
    public List<Student> findStudentsGreaterThanAge(Integer age);
    public int totalEqualIeltsScore(double score);
    public List<Student> findStudentsContainsWord(String word);
}
