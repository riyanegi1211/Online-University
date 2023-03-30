import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CourseService {

	constructor(private http:HttpClient) { }

	getURL:string= "http://localhost:8080/api/admin/getCoursesList";
	strURL:string= "http://localhost:8080/api/admin/saveCourses";
	getCoursesList():Observable<any>{
		return this.http.get(this.getURL);
	}

    saveCourses(data: any):Observable<any>{
        let headers= {'content-type':'application/json'};
        let jsonObj= JSON.stringify(data);
        return this.http.post(this.strURL,jsonObj,{'headers' : headers});
    }
}
