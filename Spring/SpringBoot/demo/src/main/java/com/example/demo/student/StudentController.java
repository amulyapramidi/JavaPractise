package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping("api/vi/Student")
public class StudentController {

    private final StudentService studentservice;

    @Autowired
    public StudentController(StudentService studentservice) {
        this.studentservice = studentservice;
    }

    @GetMapping("getHello")
    public String getHello(){
        return studentservice.getHello();
    }
    @GetMapping("getList")
    public List<String> getList(){
        return studentservice.getList();

    }
    @GetMapping("getStudent")
    public List<Student> getStudent(){
        return studentservice.getStudent();
    }

    @GetMapping(value="/getStudentXML", produces= MediaType.APPLICATION_XML_VALUE)
    public Student getStudentXML(){
        return studentservice.getStudentXML();
    }
    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        System.out.println("Inside registerNewStudent ");
        System.out.println("Inside register new student : "+student.toString());
        studentservice.addStudent(student);
    }

    @DeleteMapping(path = "{studentID}")
    public void deleteStudentById(@PathVariable Integer studentID){
        studentservice.deleteStudentByID(studentID);
    }

    @PutMapping(path = "{studentID}")
    public void updateStudentById(@PathVariable Integer studentID,
                                  @RequestParam(required = false) String name,
                                  @RequestParam(required = false) String email
        ){
        studentservice.updateStudentById(studentID,name,email);
    }
}
