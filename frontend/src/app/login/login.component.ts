import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder,  NgForm, FormControl, Validators } from '@angular/forms'
import { Router } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

	
  hide: boolean = false;

  constructor(private fb: FormBuilder, private http:HttpClient, private router:Router, private userService: UserService) {
  }

  ngOnInit() {
  }

  loginForm: FormGroup = this.fb.group({
    name: ['', [Validators.required]],
    password: ['', [Validators.required, Validators.minLength(1)]]
  })

  url = "http://localhost:8080/api/";

  
   
  redirecting(){
    console.log("called");
    this.url= this.url+"role";
    this.userService.logIn();
    const observer= {
        next: (x:any) => {console.log(x)}, 
        error: (err: any) => {console.log(err.error)}
    }
    this.http.get(this.url,{responseType: 'text' ,withCredentials: true}).subscribe(observer);
    
    this.router.navigate(['home']);
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
      next: (x: any) => {console.log(x);this.redirecting()}, 
      error: (err: any) => {console.log(err.error)}, 
      complete: () => console.log('Observer got a complete notification'),
    }
    this.http.post(url, body, { responseType: 'text', withCredentials: true }).subscribe(observer);
  }
	// username: string = "";
    // password: string = ""
  
    // regUsername: string = "";
    // regPassword: string = ""
  
    // url = "http://localhost:8080/api/";
  
    // name: string = "abc";

	// update= new FormGroup({
	// 	username: new FormControl(''),
	// 	password: new FormControl(''),
	// })
  
    // getName() {
    //   const url = this.url + "role";
    //   this.http.get(url, { responseType: 'text', withCredentials: true }).subscribe((v) => this.name = v);
    // }
  
    // onSubmit() {
    //   const url = this.url + "login";
      
  
    //   let body = {
    //     "username": this.update.value.username,
    //     "password": this.update.value.password
    //   }
    //   const observer = {
    //     next: (x: any) => {console.log(x)}, 
    //     error: (err: any) => {console.log(err.error)}, 
    //     complete: () => console.log('Observer got a complete notification'),
    //   }
    //   this.http.post(url, body, { responseType: 'text', withCredentials: true }).subscribe(observer);
    // }
  
    // onSubmitR(form: NgForm) {
    //   const url = this.url + "register";
    //   let formValue = form.value;
    //   let username = formValue.username;
    //   let password = formValue.password;
  
    //   let body = {
    //     "username": username,
    //     "password": password
    //   }
  
    //   const observer = {
    //     next: (x: any) => {console.log(x)}, 
    //     error: (err: any) => {console.log(err.error)}, 
    //     complete: () => console.log('Observer got a complete notification'),
    //   }
    //   this.http.post(url, body, { responseType: 'text', withCredentials: true }).subscribe(observer);
    // }
    
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