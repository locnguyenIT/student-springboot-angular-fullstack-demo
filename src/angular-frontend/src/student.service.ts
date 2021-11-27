import { HttpClient, HttpParams } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Student } from "./app/student";
import { environment } from "./environments/environment";

@Injectable({providedIn: 'root'})
export class StudentService{

  private apiStudentServer = 'http://localhost:8080/api/spring-boot/student' //connect to backend

  constructor(private http: HttpClient){}

  public getAllStudent(): Observable<Student[]> //get All Student from backend
  {
    return this.http.get<Student[]>(`${this.apiStudentServer}`); //localhost:8080/spring-boot/student
  }

  public addStudent(student: Student): Observable<Student>
  {
    return this.http.post<Student>(`${this.apiStudentServer}/add`,student);
  }

  public deleteStudent(studentId: number): Observable<void>
  {
    return this.http.delete<void>(`${this.apiStudentServer}/delete/${studentId}`);
  }

  public updateStudent(studentId: number, name: string, email: string,gender: string, dob: Date): Observable<Student>
  {
    const params= new HttpParams().set('name',name).set('email',email).set('gender',gender).set('dob',dob.toString());
    return this.http.put<Student>(`${this.apiStudentServer}/update/${studentId}`,params);
  }




}
