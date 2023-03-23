import { Component } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  constructor(private http: HttpClient) { }
  username: string = "";
  password: string = ""

  regUsername: string = "";
  regPassword: string = ""

  url = "http://localhost:8080/";

  name: string = "abc";
  ngOnInit() {
    this.getName();
  }
  getName() {
    const url = this.url + "name";
    this.http.get<string>(url).subscribe((v) => this.name = v);
  }

  onSubmit(form: NgForm) {
    const url = this.url + "login";
    let formValue = form.value;
    let username = formValue.username;
    let password = formValue.password;
    let headers = new HttpHeaders({ "authorization" : "Basic" + this.createBasicAuthToken(username, password) });
    console.log("Headers");
    console.log(headers);
    this.http.post(url, headers).subscribe();
  }

  createBasicAuthToken(username: string, password: string) {
    const authString = `${username}:${password}`;
    const base64AuthString = window.btoa(authString);
    // return 'Basic ' + window.btoa(username + ":" + password);
    return base64AuthString;
  }

  onSubmitR(form: NgForm) {
    const url = this.url + "register";
    let formValue = form.value;
    let username = formValue.username;
    let password = formValue.password;
    const headers = new HttpHeaders({
      'Content-Type': 'application/x-www-form-urlencoded'
    });
    const body = `username=${encodeURIComponent(username)}&password=${encodeURIComponent(password)}`;
    // let headers = { headers: { authorization: this.createBasicAuthToken(username, password) } };
    this.http.post(url, body, { headers, withCredentials: true }).subscribe();
  }
}


