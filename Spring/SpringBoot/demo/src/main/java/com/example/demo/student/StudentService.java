package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public String getHello(){
        return "Positive Vibrations only";
    }
    public List<String> getList(){
        return List.of("Positive Vibrations only","Yes");

    }
    //new Student(1,"Amulya", LocalDate.of(1994,
    //                Month.MARCH,18),"amulyapramidi@gmail.com",27)
    public List<Student> getStudent(){
        return studentRepository.findAll();
    }
    public Student getStudentXML(){
        return new Student(1,"Amulya", LocalDate.of(1994,
                Month.MARCH,18),"amulyapramidi@gmail.com");
    }

    public void addStudent(Student student) {
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.email);
        if(studentByEmail.isPresent()){
            throw new IllegalStateException("Student exists with this mail");
        }
        studentRepository.save(student);
    }

    public void deleteStudentByID(Integer studentID) {
        boolean isStudentExists = studentRepository.existsById(studentID);
        if(!isStudentExists){
            throw new IllegalStateException("Student doesn't exist with id : "+studentID);
        }
        studentRepository.deleteById(studentID);

    }
    @Transactional
    public void updateStudentById(Integer id, String name, String email) {
        System.out.println("inside updateStudentById");
        Student student = studentRepository.findById(id).
                orElseThrow(()->new IllegalStateException("student with id : "+id+" doesn't exists"));
        if(name!=null && name.length()>0 && !student.name.equalsIgnoreCase(name)){
            System.out.println("name updated");
            student.setName(name);
        }
        if(email!=null && email.length()>0 && !student.email.equalsIgnoreCase(email)){
            Optional<Student> studentByEmail = studentRepository.findStudentByEmail(email);
            if(studentByEmail.isPresent()){
                throw new IllegalStateException("Student exists with this mail");
            }
            System.out.println("email updated");
            student.setEmail(email);
        }

    }
}
