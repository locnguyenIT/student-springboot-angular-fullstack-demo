package com.example.demo.student;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;


@Entity(name = "Student") //Mapping the Student class to Student table in database
@Table //Have column id, name, email, dob
public class Student {

    @Id //id will be primary key of table student
    @SequenceGenerator(name = "student_sequence",sequenceName = "student_sequence",allocationSize = 1) //generate sequence with id auto increment begin 1
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence") //use sequence is just defined above
    private int id;
    private String name;
    private String email;
    private LocalDate dob;
    @Transient //This annotation mean is no need column age in database because age will calculate by dob
    private int age;

    public Student() {}

    public Student(int id, String name, String email, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Student(String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public int getAge() {
        return Period.between(this.dob,LocalDate.now()).getYears();
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}
