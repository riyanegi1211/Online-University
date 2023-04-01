import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class StudentServiceService {

	constructor(private http:HttpClient) { }

	strURL:string= "http://localhost:8080/api/student/getCourses";
    doURL:string= "http://localhost:8080/api/student/postCourses/courseId/data/dataId";
	getCourseInfo():Observable<any>{
		return this.http.get(this.strURL, { withCredentials: true });
	}

    updateCourseInfo():Observable<any>{
        let headers= {'content-type':'application/json'};
        return this.http.post(this.doURL, '', {'headers' : headers});
    }
}
