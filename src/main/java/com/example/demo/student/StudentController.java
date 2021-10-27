package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController //This annotation make this class request/response API from client
@RequestMapping(path = "/api/spring-boot/student") //mapping to the endpoint url
public class StudentController { //Request API , Response API

    private final StudentService studentService;

    @Autowired //StudentService autowired inject into StudentController (Dependency Injection)
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping //GET student
    public List<Student> getStudent()
    {
        return studentService.getStudent();
    }

//    case 1:
//    @GetMapping(path = "/find/{studentId}") //GET student by id
//    public Student getStudentById(@PathVariable("studentId") Integer studentId) //@PathVariable is extract the values (studentID) from the URL
//    {
//        return studentService.getStudentById(studentId);
//    }

    //case 2:
    @GetMapping(path = "/find/{studentId}") //GET student by id
    public Optional<Student> getStudentById(@PathVariable("studentId") Integer studentId) //@PathVariable is extract the values (studentID) from the URL
    {
        return studentService.getStudentById(studentId);
    }

    @PostMapping(path = "/add") //POST student
    public void addStudent(@RequestBody Student student) //@RequestBody is take the request body client and map it into a student
    {
        studentService.addStudent(student);
    }

    @DeleteMapping(path = "/delete/{studentId}") //Delete student with studentId
    public void deleteStudent(@PathVariable("studentId") Integer studentId) //@PathVariable is extract the values (studentID) from the URL
    {
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "update/{studentId}") //Update student with studentId
    public void updateStudent(@PathVariable("studentId") Integer studentId, //@PathVariable is extract the values (studentID) from the URL
                              @RequestParam(required = false) String name,  //@RequestParam is extract the query parameters from the URL. required = false mean is not required have parameter
                              @RequestParam(required = false) String email,
                              @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dob) //@RequestParam is extract the query parameters from the URL. required = false mean is not required have parameter
    {
        studentService.updateStudent(studentId,name,email,dob);
    }

//    @PutMapping(path = "update/{studentId}") //Update student with studentId
//    public void updateStudent(@PathVariable("studentId") Integer studentId, @RequestBody Student student) //@PathVariable is extract the values (studentID) from the URL
//
//    {
//        studentService.updateStudent(studentId,student);
//    }
}
