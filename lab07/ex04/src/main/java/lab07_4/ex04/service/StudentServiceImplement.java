package lab07_4.ex04.service;

import lab07_4.ex04.model.Student;
import lab07_4.ex04.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentServiceImplement implements StudentService {
    @Autowired
    private StudentRepository studentRepository;


    @Override
    public List<Student> findByAge(int age) {
        return studentRepository.findByAgeGreaterThanEqual(age);
    }

    @Override
    public int countByIelts(double ielts) {
        return studentRepository.countStudentByIelts(ielts);
    }

    @Override
    public List<Student> findByName(String name) {
        return studentRepository.findByNameContaining(name);
    }


    @Override
    public Iterable<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudent(int id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public void addStudent(Student student) {
        studentRepository.save(student);

    }

    @Override
    public void updateStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }
}
