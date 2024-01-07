package com.example.crudByJpa;

import com.example.crudByJpa.DAO.StudentDAO;
import com.example.crudByJpa.Entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudByJpaApplication {
	public static void main(String[] args) {
		SpringApplication.run(CrudByJpaApplication.class, args);
		System.out.println("Hello World");
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO student){
		return runner->{
			//createStudentObject(student);
			//readStudentData(student);
			//getAllDataFromTable(student);
			//getDataByLastName(student);
			updateData(student);
		};
	}

	private void updateData(StudentDAO student) {
		Student student1=student.findById(1l);
		student1.setFirstName("Hii");
		student.update(student1);
	}

	private void getDataByLastName(StudentDAO student) {
		List<Student> studentList=student.findByLastName("patel");
		for(Student stu:studentList){
			System.out.println(stu);
		}
	}

	private void getAllDataFromTable(StudentDAO student) {
		List<Student> studentList=student.findAll();
		for(Student stu:studentList){
			System.out.println(stu);
		}
	}

	private void readStudentData(StudentDAO student) {
		Student student1=student.findById(1l);
		System.out.println(student1.getId()+" "+student1.getEmail()+" "
				+student1.getFirstName()+" "+student1.getLastName()
		);
	}

	private void createStudentObject(StudentDAO student) {
		System.out.println("create an object");
		Student students=new Student("Hello","world","helloWorld@gmail.com");
		student.save(students);
		System.out.println("data saved done"+students.getId() );

	}

}
