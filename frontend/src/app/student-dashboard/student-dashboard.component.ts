import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgbOffcanvas, OffcanvasDismissReasons } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-student-dashboard',
  templateUrl: './student-dashboard.component.html',
  styleUrls: ['./student-dashboard.component.css']
})
export class StudentDashboardComponent {
    opened = false;
    closeResult = '';
    ngOnInit() {
        console.log("We are on home component")
    }
    constructor(private http:HttpClient, private router:Router, private offcanvasService: NgbOffcanvas){}
    loggingOut(){
        console.log("logout in progress");
        let headers= {'content-type':'application/json'};
        let strURL= `http://localhost:8080/api/logout`;
        // let jsonObj= JSON.stringify();
        this.http.post(strURL,{'headers' : headers, withCredentials: true});
        localStorage.removeItem("userId");
        this.router.navigate(['login']);
    }
    open(content: any) {
		this.offcanvasService.open(content, { ariaLabelledBy: 'offcanvas-basic-title' }).result.then(
			(result) => {
				this.closeResult = `Closed with: ${result}`;
			},
			(reason) => {
				this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
			},
		);
	}
    private getDismissReason(reason: any): string {
		if (reason === OffcanvasDismissReasons.ESC) {
			return 'by pressing ESC';
		} else if (reason === OffcanvasDismissReasons.BACKDROP_CLICK) {
			return 'by clicking on the backdrop';
		} else {
			return `with: ${reason}`;
		}
	}
}
