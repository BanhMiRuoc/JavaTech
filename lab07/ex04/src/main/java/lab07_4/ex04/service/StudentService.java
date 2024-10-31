package lab07_4.ex04.service;
import lab07_4.ex04.model.Student;
public interface StudentService {
    public Iterable<Student> getStudents();
    public Student getStudent(int id);
    public void addStudent(Student student);
    public void updateStudent(Student student);
    public void deleteStudent(int id);
}
