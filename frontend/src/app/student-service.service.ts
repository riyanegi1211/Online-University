import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StudentServiceService {

	constructor(private http:HttpClient) { }

	strURL:string= "http://localhost:8080/api/student/getCourses";
	getCourseInfo():Observable<any>{
		return this.http.get(this.strURL, { withCredentials: true });
	}

}
