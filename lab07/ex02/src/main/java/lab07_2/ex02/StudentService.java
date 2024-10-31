package lab07_2.ex02;

public interface StudentService {
    public Iterable<Student> getStudents();
    public Student getStudent(int id);
    public void addStudent(Student student);
    public void updateStudent(Student student);
    public void deleteStudent(int id);
}
