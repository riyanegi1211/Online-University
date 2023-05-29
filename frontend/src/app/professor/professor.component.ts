import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgbOffcanvas, OffcanvasDismissReasons } from '@ng-bootstrap/ng-bootstrap';
import { UserService } from '../user.service';
import { Student } from '../Student';

@Component({
  selector: 'app-professor',
  templateUrl: './professor.component.html',
  styleUrls: ['./professor.component.scss']
})
export class ProfessorComponent {
    closeResult = '';

	constructor(private offcanvasService: NgbOffcanvas, private http:HttpClient, private router:Router, private userService: UserService) {}

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

    loggingOut(){
        console.log("logout in progress");
        let headers= {'content-type':'application/json'};
        let strURL= `http://localhost:8080/api/logout`;
        // let jsonObj= JSON.stringify();
        this.http.post(strURL,{'headers' : headers, withCredentials: true});
        localStorage.removeItem("userId");
        this.router.navigate(['login']);
    }

    loadStudentsList()
    {
        this.router.navigate(['studentlist']);
    }
}
