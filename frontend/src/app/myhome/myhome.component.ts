import { Component, ElementRef, QueryList, ViewChild, ViewChildren } from '@angular/core';
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
    // @ViewChild('progDiv') progDiv!: ElementRef<HTMLInputElement>;
    @ViewChildren('progDiv') progDiv:QueryList<ElementRef> | undefined;
    calendarOptions: CalendarOptions=  {
        initialView: 'dayGridMonth',
        plugins: [dayGridPlugin,interactionPlugin],
        weekends: false,
        events: this.eventData
    }
    info:any=[];
    response:any=[];
    send:any=[];
    progressArr:number[]=[33.3,50];
    i:number=0;
    j:number=0;
    lec:number=0;
    answer:number[]=[];
	// this.eventData= data; console.log(this.eventData)
	ngOnInit(){
		this.studentService.getCourseInfo().subscribe({
			next: (data) => {
                console.log(data);
                for(let y of data){
                    y.attendedLectures = this.progressArr[this.i]; 
                    // console.log(y);
                    y.course.answer= y.attendedLectures;
                    console.log(y);
                    this.send.push(y.course);
                    this.i=this.i+1;
                }
				// for(var obj of data){
				// 	this.res= obj.progress;
                //     console.log(this.res);
				// 	this.answer= this.res.toFixed(2) + "%";
				// 	this.progDiv.nativeElement.style.width= `${this.answer}`;
				// }
			},
			error: (err) => {console.log(err)}
		});
		// this.fetchEvents();

		this.http.get<any[]>(this.getURL, { withCredentials: true }).subscribe({
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

    ngAfterViewInit(){
        
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
	

	loadDashboard(){
		this.router.navigate(['dashboard']);
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
}
