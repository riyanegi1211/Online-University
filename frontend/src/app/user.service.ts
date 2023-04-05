import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

	currentUser: number= 0;
	isLoggedIn: boolean = false;
	isRegistered: boolean = false;

	constructor(private http:HttpClient) { }

	loggedIn():boolean {
		return localStorage.getItem("loggedin") === "true";
	}
	logIn() {
		// this.isLoggedIn = true;
		localStorage.setItem("loggedin", "true");
	}

	getStudentsList():Observable<any>{
        let uid = localStorage.getItem("userId");
	    let getURL= `http://localhost:8080/api/admin/${uid}/students`;
		return this.http.get(getURL);
	}

    saveStudents(data: any):Observable<any>{
        let headers= {'content-type':'application/json'};
        let uid = localStorage.getItem("userId");
        let strURL= `http://localhost:8080/api/admin/${uid}/students`;
        let jsonObj= JSON.stringify(data);
        console.log(strURL);
        return this.http.post(strURL,jsonObj,{'headers' : headers});
    }

    deleteData(courseId:number):Observable<any>{
        let uid = localStorage.getItem("userId");
        let delURL= `http://localhost:8080/api/admin/${uid}/students`;
        return this.http.delete(delURL + '/' + courseId, {responseType: 'text'});
    }

    updateStudents(data: any,studentId:number):Observable<any>{
        let uid = localStorage.getItem("userId");
        let delURL= `http://localhost:8080/api/admin/${uid}/students`;
        return this.http.put(delURL + '/' + studentId,data);
    }
}
