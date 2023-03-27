import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StudentServiceService {

	constructor(private http:HttpClient) { }

	strURL:string= "http://localhost:4200/api/user/getCourseInfo";
	getCourseInfo():Observable<any>{
		return this.http.get(this.strURL);
	}

}
