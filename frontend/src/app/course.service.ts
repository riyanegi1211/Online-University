import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { SharedService } from './shared.service';

@Injectable({
  providedIn: 'root'
})
export class CourseService {

	constructor(private http:HttpClient, private sharedService:SharedService) { }

    cid= this.sharedService.getUserId();
	getURL:string= `http://localhost:8080/api/admin/${this.cid}/courses`;
	strURL:string= `http://localhost:8080/api/admin/${this.cid}/courses`;
    delURL:string= `http://localhost:8080/api/admin/${this.cid}/courses`;
	getCoursesList():Observable<any>{
		return this.http.get(this.getURL);
	}

    saveCourses(data: any):Observable<any>{
        let headers= {'content-type':'application/json'};
        let jsonObj= JSON.stringify(data);
        console.log(this.strURL);
        return this.http.post(this.strURL,jsonObj,{'headers' : headers});
    }

    deleteData(courseId:number):Observable<any>{
        return this.http.delete(this.delURL + '/' + courseId);
    }

    updateCourses(data: any,courseId:number):Observable<any>{
        // let headers= {'content-type':'application/json'};
        // let jsonObj= JSON.stringify(data);
        return this.http.put(this.delURL + '/' + courseId,data);
    }
}
