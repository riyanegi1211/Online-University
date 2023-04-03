import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {

    currentUser: number= 0;
    isLoggedIn: boolean = false;
    isRegistered: boolean = false;

    loggedIn():boolean {
        return localStorage.getItem("loggedin") === "true";
    }
    logIn() {
        // this.isLoggedIn = true;
        localStorage.setItem("loggedin", "true");
    }
}
