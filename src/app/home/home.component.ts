import { Component } from '@angular/core';
import { CalendarOptions } from '@fullcalendar/core';
import { NgbOffcanvas, OffcanvasDismissReasons } from '@ng-bootstrap/ng-bootstrap';
import dayGridPlugin from '@fullcalendar/daygrid';
import interactionPlugin from '@fullcalendar/interaction';
import { StudentServiceService } from '../student-service.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent {
	closeResult = '';

	constructor(private offcanvasService: NgbOffcanvas, private studentService:StudentServiceService) {}

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
	calendarOptions: CalendarOptions = {
		initialView: 'dayGridMonth',
		plugins: [dayGridPlugin,interactionPlugin],
		weekends: false,
		events: [
			{ title: 'Meeting', start: new Date() , end: '2023-03-24'},
		],
  	};

	upcoming:any[]=[
		{
			description: "Event 1"
		},
		{
			description: "Event 2"
		},
		{
			description: "Event 3"
		},
		{
			description: "Event 4"
		},
		{
			description: "Event 5"
		}
	]

	getCourseInfo(){
		this.studentService.getCourseInfo().subscribe({
			next: (data) => {console.log(data)},
			error: (err) => {console.log(err)}
		});
	}


}
