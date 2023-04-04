import { Component, ElementRef, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { CalendarOptions } from '@fullcalendar/core';
import { NgbOffcanvas, OffcanvasDismissReasons } from '@ng-bootstrap/ng-bootstrap';
import dayGridPlugin from '@fullcalendar/daygrid';
import interactionPlugin from '@fullcalendar/interaction';
import { EventInput } from '@fullcalendar/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { StudentServiceService } from '../student-service.service';
import { HttpClient } from '@angular/common/http';
import { Progress } from '../Progress';
import { FullCalendarComponent } from '@fullcalendar/angular';
import { constrainPoint } from '@fullcalendar/core/internal';

@Component({
  selector: 'app-myhome',
  templateUrl: './myhome.component.html',
  styleUrls: ['./myhome.component.scss']
})
export class MyhomeComponent {
	closeResult = '';

	// events: EventInput[] = [];

    @ViewChild('calendar')
    calendarComponent!: FullCalendarComponent;

	getURL:string= "http://localhost:8080/api/student/1/calender";

	constructor(private offcanvasService: NgbOffcanvas, private studentService:StudentServiceService, private elementRef:ElementRef, private router:Router, private http:HttpClient) {}

	eventData:Progress[]  =[]; // new Progress("hello", "2023-04-03", "2023-04-10"), new Progress("hello", "2023-04-03", "2023-04-11")

    progress!: Progress;
    @ViewChild('progDiv') progDiv!: ElementRef;
    calendarOptions: CalendarOptions=  {
        initialView: 'dayGridMonth',
        plugins: [dayGridPlugin,interactionPlugin],
        weekends: false,
        events: this.eventData
      }
    info:any=[];
    response:any=[];
    send:any=[];
	// this.eventData= data; console.log(this.eventData)
	ngOnInit(){
		this.studentService.getCourseInfo().subscribe({
			next: (data) => {
                console.log(data);
                for(let y of data){
                    console.log(y.course);
                    this.send.push(y.course);
                }
				for(var obj of data){
					this.res= obj.progress;
					this.answer= this.res.toFixed(2) + "%";
					this.progDiv.nativeElement.style.width= `${this.answer}`;
				}
			},
			error: (err) => {console.log(err)}
		});
		// this.fetchEvents();
		this.http.get<any[]>(this.getURL).subscribe({
			next: (data) => { 
								console.log(data)
                                let temp:Object[];
                                // temp = data;
                                for(const k of data){
                                    this.eventData.push(new Progress(k.task, k.startDate, k.endDate))
                                }
                                console.log(this.eventData);
                                
                                let calendarApi = this.calendarComponent.getApi();
                                // console.log(calendarApi)
                                for (const x of this.eventData) {
                                    calendarApi.addEvent(x);
                                }
                                // calendarApi.render()
                                // const x = calendarApi.getEvents
                                // console.log(x())
								// this.eventData= data
                                // this.eventData= Object.values(data)
								// console.log(this.eventData[0])
                                // this.progress = new Progress(this.eventData[0],this.eventData[1],this.eventData[2])
							},
			error: (err) => {console.log(err)}
		})
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

	// fetchEvents(): void {
	//     this.http.get(this.getURL).subscribe((data: any) => {
	//       this.events = data.map((event: any) => ({
	//         title: event.title,
	//         start: event.startDate,
	//         end: event.endDate
	//       }));
	//     });
	//   }


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


	


	res:number=0;
	answer:string="";
	

	loadDashboard(){
		this.router.navigate(['dashboard']);
	}
}
