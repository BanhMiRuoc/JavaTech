package lab07_5.ex05;

import lab07_5.ex05.model.Student;
import lab07_5.ex05.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Ex05Application implements CommandLineRunner {
	@Autowired
	private StudentService studentService;

	public static void main(String[] args) {
		SpringApplication.run(Ex05Application.class, args);
	}
	private void showStudents() {
		List<Student> students = (List<Student>) this.studentService.getStudents();
		for (Student student : students) {
			System.out.println(student);
		}
	}
	@Override
	public void run(String... args) throws Exception {

		Student student01 = this.studentService.getStudent(1);
		Student student02 = this.studentService.getStudent(2);
		Student student03 = this.studentService.getStudent(3);

		System.out.println("List student greater than 20 years old: ");
		int age = 20;
		List<Student> studentsEqualAge = this.studentService.findByAge(age);
		for (Student student : studentsEqualAge) {
			System.out.println(student);
		}

		double score = 7.0;
		int counting = this.studentService.countByIelts(score);
		System.out.println("Count the student have score equal 7.0 = " + counting);

		String word = "n";
		System.out.println("List the student constrain the word: " + word);
		List<Student> lists = this.studentService.findByName(word);
		for (Student student : lists) {
			System.out.println(student);
		}
	}
}
