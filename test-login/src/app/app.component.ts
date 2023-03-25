import { Component } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  basicAuth = false;
  constructor(private http: HttpClient) { }
  username: string = "";
  password: string = ""

  regUsername: string = "";
  regPassword: string = ""

  url = "http://localhost:8080/api/";

  name: string = "abc";

  getName() {
    const url = this.url + "role";
    this.http.get(url, { responseType: 'text', withCredentials: true }).subscribe((v) => this.name = v);
  }

  onSubmit(form: NgForm) {
    const url = this.url + "login";
    let formValue = form.value;
    let username = formValue.username;
    let password = formValue.password;

    let body = {
      "username": username,
      "password": password
    }
    this.http.post(url, body, { responseType: 'text', withCredentials: true }).subscribe();
  }

  onSubmitR(form: NgForm) {
    const url = this.url + "register";
    let formValue = form.value;
    let username = formValue.username;
    let password = formValue.password;

    let body = {
      "username": username,
      "password": password
    }

    // https://rxjs-dev.firebaseapp.com/guide/observer
    const observer = {
      next: (x: any) => {console.log(x)}, // redirect to login page
      error: (err: any) => {console.log(err.error)}, // redirect to login or show error
      complete: () => console.log('Observer got a complete notification'),
    }
    this.http.post(url, body, { responseType: 'text', withCredentials: true }).subscribe(observer);
  }
}


