import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { StudentService } from 'src/student.service';
import { Student } from './student';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  public students: Student[] = [];
  public getInfoStudent!: Student;
  public id!: number;
  public name!: string ;
  public email!: string;
  public dob!:  Date;

  constructor(private studentService: StudentService){}

  ngOnInit()
  {
    this.getAllStudent();
  }

  public getAllStudent(): void
  {
    this.studentService.getAllStudent().subscribe(
      (response: Student[]) => {
        this.students = response;
        console.log(this.students);
      }, //Reponse data student from backend
      (error: HttpErrorResponse) => {
        alert(error.message)} //If error. Alert message
    );
  }

  public getStudent(student: Student)
  {
    this.getInfoStudent = student;
    this.id = this.getInfoStudent.id;
    this.name = this.getInfoStudent.name;
    this.email = this.getInfoStudent.email;
    this.dob = this.getInfoStudent.dob;
  }


  public onAddStudent(addForm: NgForm): void
  {
    document.getElementById('add-student-close')?.click(); //when save student, click close button to shutdown form
    // addForm.value is student
    this.studentService.addStudent(addForm.value).subscribe(
      (response: Student) => {
        console.log(response);
        this.getAllStudent();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );

  }

  public onDeleteStudent(studentId: number): void
  {
    document.getElementById('btn-no-delete')?.click(); //when save student, click close button to shutdown form
    this.studentService.deleteStudent(studentId).subscribe(
      (response: void) => {
        console.log(response);
        this.getAllStudent();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onUpdateStudent(student: Student ): void
  {
    document.getElementById('btn-edit-close')?.click(); //when save student, click close button to shutdown form
    this.studentService.updateStudent(student.id,student.name,student.email,student.dob).subscribe(
      (response: Student) => {
        console.log(response);
        this.getAllStudent();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public searchStudent(input: string):void
  {
    console.log(input);
    const result: Student[] = [];
    console.log(result);
    for(const student of this.students) //loop of js
    {
      if(student.name.toLowerCase().indexOf(input.toLowerCase()) !== -1 //if student.name include input
        || student.email.toLowerCase().indexOf(input.toLowerCase()) !== -1) //if student.email include input
      {
        result.push(student); //push student in result array
      }

    }
    this.students = result; //filter new list student when input match student.name or student.email
    if(result.length === 0 || !input) //if result empty or input empty
    {
      this.getAllStudent(); //reload list student
    }
  }

}
