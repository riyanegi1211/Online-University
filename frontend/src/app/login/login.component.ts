import { Component } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { FormBuilder, FormGroup, NgForm, Validators } from '@angular/forms';
import { Router } from '@angular/router';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
    basicAuth = false;
    constructor(private http: HttpClient, private router:Router) { }
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
      const observer = {
        next: (x: any) => {console.log(x);this.router.navigate(['home'])}, // redirect to login page
        error: (err: any) => {console.log(err.error)}, // redirect to login or show error
        complete: () => console.log('Observer got a complete notification'),
      }
      this.http.post(url, body, { responseType: 'text', withCredentials: true }).subscribe(observer);
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
    
    // hide: boolean = false;

    // constructor(private fb: FormBuilder, private router:Router, private http: HttpClient) {
    // }
  
    // ngOnInit() {
    // }
  
    // loginForm: FormGroup = this.fb.group({
    //   email: ['', [Validators.required, Validators.email]],
    //   password: ['', [Validators.required, Validators.minLength(6)]]
    // })
  
  
    // onLogin() {
    //   if (!this.loginForm.valid) {
    //     return;
    //   }
    //   console.log(this.loginForm.value);
    //       const url = this.url + "login";
    //   let formValue = this.loginForm.value;
    //   let username = formValue.username;
    //   let password = formValue.password;
  
    //   let body = {
    //     "username": username,
    //     "password": password
    //   }
    //   const observer = {
    //     next: (x: any) => {console.log(x);this.router.navigate(['home'])}, // redirect to login page
    //     error: (err: any) => {console.log(err.error)}, // redirect to login or show error
    //     complete: () => console.log('Observer got a complete notification'),
    //   }
    //   this.http.post(url, body, { responseType: 'text', withCredentials: true }).subscribe(observer);
      
    // }
}
