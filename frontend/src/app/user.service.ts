import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor() { }
  currentUser: string = "";
  isLoggedIn: boolean = false;
  isRegistered: boolean = false;

  ngOnInit() {
    this.isLoggedIn = localStorage.getItem("loggedin") === "true";
  }
  loggedIn():boolean {
    return this.isLoggedIn || this.isRegistered;
  }
  logIn() {
    this.isLoggedIn = true;
    localStorage.setItem("loggedin", "true");
  }
}
