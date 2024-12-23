package lab07_4.ex04.service;
import lab07_4.ex04.model.Student;
import java.util.List;

public interface StudentService {
    public Iterable<Student> getStudents();
    public Student getStudent(int id);
    public void addStudent(Student student);
    public void updateStudent(Student student);
    public void deleteStudent(int id);
    List<Student> findByAge(int age);
    int countByIelts(double ielts);
    List<Student> findByName(String name);
}
