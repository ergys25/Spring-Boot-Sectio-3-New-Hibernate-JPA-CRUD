package com.love2code.cruddemo;

import com.love2code.cruddemo.DAO.StudentDAO;
import com.love2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
//            createStudent(studentDAO);
//            createMultipleStudents(studentDAO);

//            System.out.println("Student is: " + studentDAO.findById(1));

//            queryForStudents(studentDAO);
            queryForStudentsByLastName(studentDAO);
        };
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {
        List<Student> theStudents = studentDAO.findByLastName("Doe");

        for(Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }
    }

    private void queryForStudents(StudentDAO studentDAO) {
        List<Student> theStudents = studentDAO.findAll();

        for(Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }


    }

    private void readStudent(StudentDAO studentDAO) {
        Student student = studentDAO.findById(1);
    }

    private void createStudent(StudentDAO studentDAO) {

        // create a student

        System.out.println("Creating a new student...");
        Student tempStudent = new Student("Paul", "Wall", "Paul@gmail.com");

        // save the student

        System.out.println("Saving the student...");
        studentDAO.save(tempStudent);

        // display the student

        System.out.println("Saved student: " + tempStudent);

    }

    private void createMultipleStudents(StudentDAO studentDAO) {

        // create a student

        System.out.println("Creating a new student...");
        Student tempStudent1 = new Student("John", "Doe", "john@luv2code.com");
        Student tempStudent2 = new Student("Mary", "Public", "mary@love2code.com");
        Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@love2code.com");


        // save the student

        System.out.println("Saving the student...");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);


    }
}
