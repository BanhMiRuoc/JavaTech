package lab07_5.ex05.repository;

import lab07_5.ex05.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Integer> {
    @Query("SELECT s FROM Student s WHERE s.age >= :age")
    List<Student> findByAge(int age);
    @Query("SELECT count(s) FROM Student s WHERE s.ielts = :ielts")
    int counting(double ielts);
    @Query("SELECT s FROM Student s WHERE s.name like %:name%")
    List<Student> findByName(String name);
}
