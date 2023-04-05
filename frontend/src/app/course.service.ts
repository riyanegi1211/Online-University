import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { SharedService } from './shared.service';
import { Course } from './Course';

@Injectable({
  providedIn: 'root'
})
export class CourseService {

	constructor(private http:HttpClient, private sharedService:SharedService) { }

    // uid:string="";
	getCoursesList():Observable<any>{
        // this.uid= this.sharedService.getUserId();
        let uid = localStorage.getItem("userId");
	    let getURL= `http://localhost:8080/api/admin/${uid}/courses`;
		return this.http.get(getURL);
	}

    saveCourses(data: any):Observable<any>{
        let headers= {'content-type':'application/json'};
        // this.uid= this.sharedService.getUserId();
        let uid = localStorage.getItem("userId");
        let strURL= `http://localhost:8080/api/admin/${uid}/courses`;
        let jsonObj= JSON.stringify(data);
        console.log(strURL);
        return this.http.post(strURL,jsonObj,{'headers' : headers});
    }

    deleteData(courseId:number):Observable<any>{
        let uid = localStorage.getItem("userId");
        let delURL= `http://localhost:8080/api/admin/${uid}/courses`;
        return this.http.delete(delURL + '/' + courseId, {responseType: 'text'});
    }

    updateCourses(data: any,courseId:number):Observable<any>{
        // let headers= {'content-type':'application/json'};
        // let jsonObj= JSON.stringify(data);
        let uid = localStorage.getItem("userId");
        let delURL= `http://localhost:8080/api/admin/${uid}/courses`;
        return this.http.put(delURL + '/' + courseId,data);
    }
}
