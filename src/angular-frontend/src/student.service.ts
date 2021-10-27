import { HttpClient, HttpParams } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Student } from "./app/student";
import { environment } from "./environments/environment";

@Injectable({providedIn: 'root'})
export class StudentService{

  private apiStudentServer = environment.apiStudentURL;

  constructor(private http: HttpClient){}

  public getAllStudent(): Observable<Student[]> //get All Student from backend
  {
    return this.http.get<Student[]>(`${this.apiStudentServer}/student`); //localhost:8080/spring-boot/student
  }

  public addStudent(student: Student): Observable<Student>
  {
    return this.http.post<Student>(`${this.apiStudentServer}/student/add`,student);
  }

  public deleteStudent(studentId: number): Observable<void>
  {
    return this.http.delete<void>(`${this.apiStudentServer}/student/delete/${studentId}`);
  }

  public updateStudent(studentId: number, name: string, email: string, dob: Date): Observable<Student>
  {
    const params= new HttpParams().set('name',name).set('email',email).set('dob',dob.toString());
    return this.http.put<Student>(`${this.apiStudentServer}/student/update/${studentId}`,params);
  }




}
