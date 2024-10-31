package lab07_5.ex05.service;

import lab07_5.ex05.model.Student;

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
