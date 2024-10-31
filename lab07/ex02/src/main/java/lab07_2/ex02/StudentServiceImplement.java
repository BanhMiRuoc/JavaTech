package lab07_2.ex02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImplement implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
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