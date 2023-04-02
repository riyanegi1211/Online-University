import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { UserService } from './user.service';

@Injectable({
    providedIn: 'root'
})
export class StudentServiceService {

	constructor(private http:HttpClient, private userService:UserService) { }

	strURL:string= "http://localhost:8080/api/student/getCourses";
    
	getCourseInfo():Observable<any>{
		return this.http.get(this.strURL, { withCredentials: true });
	}

    updateCourseInfo(key:any, cid:any):Observable<any>{
        let sid = this.userService.currentUser;
        let doURL= `http://localhost:8080/api/student/${sid}/postCourses/${cid}/data/${key}`;
        let headers= {'content-type':'application/json'};
        return this.http.post(doURL, '', {'headers' : headers});
    }
}
