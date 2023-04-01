import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {

    currentUser: string = "";
    isLoggedIn: boolean = false;
    isRegistered: boolean = false;

    // ngOnInit() {
    //     this.isLoggedIn = localStorage.getItem("loggedin") === "true";
    // }
    // constructor(){
    //     this.isLoggedIn = localStorage.getItem("loggedin") === "true"
    // }
    loggedIn():boolean {
        return localStorage.getItem("loggedin") === "true";
    }
    logIn() {
        // this.isLoggedIn = true;
        localStorage.setItem("loggedin", "true");
    }
}
