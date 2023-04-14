import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class CourseService {

	constructor(private http:HttpClient) { }

	getCoursesList():Observable<any>{
        let uid = localStorage.getItem("userId");
	    let getURL= `http://localhost:8080/api/admin/${uid}/courses`;
		return this.http.get(getURL, { withCredentials: true });
	}

    saveCourses(data: any):Observable<any>{
        let headers= {'content-type':'application/json'};
        let uid = localStorage.getItem("userId");
        let strURL= `http://localhost:8080/api/admin/${uid}/courses`;
        let jsonObj= JSON.stringify(data);
        console.log(strURL);
        return this.http.post(strURL,jsonObj,{'headers' : headers, withCredentials: true});
    }

    deleteData(courseId:number):Observable<any>{
        let uid = localStorage.getItem("userId");
        let delURL= `http://localhost:8080/api/admin/${uid}/courses`;
        return this.http.delete(delURL + '/' + courseId, {responseType: 'text', withCredentials: true });
    }

    updateCourses(data: any,courseId:number):Observable<any>{
        let uid = localStorage.getItem("userId");
        let delURL= `http://localhost:8080/api/admin/${uid}/courses`;
        return this.http.put(delURL + '/' + courseId,data, { withCredentials: true });
    }

    getChartDataByBranch(){
        let uid = localStorage.getItem("userId");
	    let getURL= `http://localhost:8080/api/admin/${uid}/chart/branch`;
        return this.http.get(getURL, { withCredentials: true });
    }


    getChartDataBySemester(){
        let uid = localStorage.getItem("userId");
	    let getURL= `http://localhost:8080/api/admin/${uid}/chart/semester`;
        return this.http.get(getURL, { withCredentials: true });
    }
}
