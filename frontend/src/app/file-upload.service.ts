import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest, HttpEvent } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UserService } from './user.service';

@Injectable({
  providedIn: 'root'
})
export class FileUploadService {
  private baseUrl = 'http://localhost:8080';

  constructor(private http: HttpClient, private userService:UserService) { }

  upload(file: File): Observable<HttpEvent<any>> {
    const formData: FormData = new FormData();
    let cid= localStorage.getItem("courseID");
    formData.append('file', file);
    let uid = localStorage.getItem("userId");
    const req = new HttpRequest('POST', `${this.baseUrl}/api/student/${uid}/course/${cid}/upload`, formData, {
      reportProgress: true,
      responseType: 'json',
      withCredentials: true 
    });

    return this.http.request(req);
  }

  getFiles(): Observable<any> {
    let uid = localStorage.getItem("userId");
    let cid= localStorage.getItem("courseID");
    return this.http.get(`${this.baseUrl}/api/student/${uid}/course/${cid}/files`, { withCredentials: true });
  }
}