package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration //Config & set 2 student in database
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository)
    {
        return args ->  {
            Student loc = new Student(
                    "Nguyen Thanh Loc",
                    "ntloc.developer@gmail.com",
                    Gender.Male,
                    LocalDate.of(1999, Month.SEPTEMBER, 28));

            Student linh = new Student(
                    "Tran Ha Linh",
                    "halinh@gmail.com",
                    Gender.Female,
                    LocalDate.of(2002, Month.DECEMBER, 12));
            Student hoang = new Student(
                    "Nguyen Huy Hoang",
                    "hoang@gmail.com",
                    Gender.Male,
                    LocalDate.of(1998, Month.OCTOBER, 19));
            Student thao = new Student(
                    "Phung Hoai Thao",
                    "thao@gmail.com",
                    Gender.Female,
                    LocalDate.of(2001, Month.JUNE, 06));
            Student hung = new Student(
                    "Nguyen Nam Hung ",
                    "hung@gmail.com",
                    Gender.Male,
                    LocalDate.of(2000, Month.JULY, 15));

            repository.saveAll(List.of(loc,linh,hoang,thao,hung));
        };
    }
}
