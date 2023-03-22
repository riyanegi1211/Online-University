import { MediaMatcher } from '@angular/cdk/layout';
import { ChangeDetectorRef, Component, OnInit, ViewChild } from '@angular/core';
import { MatSidenav } from '@angular/material/sidenav';
import {MatToolbarModule} from '@angular/material/toolbar';
import { Calendar, CalendarOptions } from '@fullcalendar/core';
import { NgbOffcanvas, OffcanvasDismissReasons, NgbDatepickerModule } from '@ng-bootstrap/ng-bootstrap';
import * as bootstrap from 'bootstrap';
import dayGridPlugin from '@fullcalendar/daygrid';
import interactionPlugin from '@fullcalendar/interaction';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})

export class AppComponent implements OnInit{
	title = 'OnlineUniversity';

	ngOnInit(): void {
		// // alert js
		// const alertPlaceholder = document.getElementById('liveAlertPlaceholder')
	
		// const alert = (message : string, type : string) => {
		//   const wrapper = document.createElement('div')
		//   wrapper.innerHTML = [
		// 	`<div class="alert alert-${type} alert-dismissible" role="alert">`,
		// 	`   <div>${message}</div>`,
		// 	'   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>',
		// 	'</div>'
		//   ].join('')
	
		//   alertPlaceholder?.append(wrapper)
		// }
	
		// const alertTrigger = document.getElementById('liveAlertBtn')
		// if (alertTrigger) {
		//   alertTrigger.addEventListener('click', () => {
		// 	alert('Hey, this is a earthquake alert', 'danger')
		//   })
		// }
	
	
	
		// // popover js
		// const popoverTriggerList = document.querySelectorAll('[data-bs-toggle="popover"]')
		// const popoverList = [...popoverTriggerList].map(popoverTriggerEl => new bootstrap.Popover(popoverTriggerEl))
		// // SO50234481
	
	
		// // toast js
		// const toastTrigger = document.getElementById('liveToastBtn')
		// const toastLiveExample = document.getElementById('liveToast')! // SO63520680
		// if (toastTrigger) {
		//   toastTrigger.addEventListener('click', () => {
		// 	const toast = new bootstrap.Toast(toastLiveExample)
	
		// 	toast.show()
		//   })
		// }
	
		// // tooltip js
		// const tooltipTriggerList = document.querySelectorAll('[data-bs-toggle="tooltip"]')
		// const tooltipList = [...tooltipTriggerList].map(tooltipTriggerEl => new bootstrap.Tooltip(tooltipTriggerEl))
	}

	closeResult = '';

	constructor(private offcanvasService: NgbOffcanvas) {}

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
}
