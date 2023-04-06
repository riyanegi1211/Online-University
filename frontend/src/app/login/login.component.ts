import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, NgForm, FormControl, Validators } from '@angular/forms'
import { Router } from '@angular/router';
import { UserService } from '../user.service';
import { SharedService } from '../shared.service';
import { Buffer } from 'buffer';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  hide: boolean = false;

  constructor(private fb: FormBuilder, private http: HttpClient, private router: Router, private userService: UserService, private sharedService: SharedService ) {
  }

  ngOnInit() {
  }

  loginForm: FormGroup = this.fb.group({
    name: ['', [Validators.required]],
    password: ['', [Validators.required, Validators.minLength(1)]]
  })

  url = "http://localhost:8080/api/";



  redirecting(x: any) {
    console.log("called");
    const roleUrl = this.url + "role";
    this.userService.logIn();
    // const observer = {
    //   next: (x: any) => { console.log(x) },
    //   error: (err: any) => { console.log(err.error) }
    // }
    // this.http.get(roleUrl, { responseType: 'text', withCredentials: true }).subscribe(observer);
    if(x.role == "ADMIN")
    {
        this.router.navigate(['admin']);
    }
    else if(x.role == "PROFESSOR")
    {
        this.router.navigate(['professor']);
    }
    else
        this.router.navigate(['home']);
  }

  onLogin() {

    if (!this.loginForm.valid) {
      return;
    }
    console.log(this.loginForm.value);
    const loginUrl = this.url + "login";
    let formValue = this.loginForm.value;
    let username = formValue.name;
    let password = formValue.password;

    let body = {
      "username": username,
      "password": password
    }

    // let headers = new HttpHeaders();
    // let data = username + ':' + password
    // let encodedCredentials = Buffer.from(data).toString('base64');
    // headers = headers.append('Authorization', 'Basic ' + encodedCredentials);
    const observer = {
      next: (x: any) => {   console.log(x); 
                            // const val= JSON.parse(x);
                            // this.sharedService.setUserId(val.userId);
                            // console.log(this.sharedService.getUserId());
                            localStorage.setItem("userId",'2');
                            this.redirecting(x) 
                        },
      error: (err: any) => { console.log(err.error) },
      complete: () => console.log('Observer got a complete notification'),
    }
    this.http.post(loginUrl, body, { responseType: 'text', withCredentials: true }).subscribe(observer);
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