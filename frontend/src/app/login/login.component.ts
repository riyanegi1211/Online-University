import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms'
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  hide: boolean = false;

  constructor(private fb: FormBuilder, private http:HttpClient, private router:Router) {
  }

  ngOnInit() {
  }

  loginForm: FormGroup = this.fb.group({
    name: ['', [Validators.required, Validators.required]],
    password: ['', [Validators.required, Validators.minLength(1)]]
  })

  url = "http://localhost:8080/api/";

  // do a get call to check role and redirect to home
  redirecting(){
    console.log("called");
    this.router.navigate(['/home']);
  }
  onLogin() {
    
    if (!this.loginForm.valid) {
      return;
    }
    console.log(this.loginForm.value);
    const url = this.url + "login";
    let formValue = this.loginForm.value;
    let username = formValue.name;
    let password = formValue.password;

    let body = {
      "username": username,
      "password": password
    }
    const observer = {
      next: (x: any) => {console.log(x);this.redirecting()}, // redirect to login page
      error: (err: any) => {console.log(err.error)}, // redirect to login or show error
      complete: () => console.log('Observer got a complete notification'),
    }
    this.http.post(url, body, { responseType: 'text' }).subscribe(observer);
  }

}