import { Component, ElementRef, ViewChild } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { er } from '@fullcalendar/core/internal-common';
import { CourseService } from '../course.service';

@Component({
  selector: 'app-coursecrud',
  templateUrl: './coursecrud.component.html',
  styleUrls: ['./coursecrud.component.scss']
})
export class CoursecrudComponent {

	constructor(private courseService: CourseService, private fb:FormBuilder){}
	
	// @ViewChild('cid') courseId!: ElementRef;
	// @ViewChild('cname') courseName!: ElementRef;
	// @ViewChild('lecnum') totalLectures!: ElementRef;
	// @ViewChild('stat') status!: ElementRef;


	// ngOnChanges(){
	// 	console.log(this.courseId.nativeElement.value);
	// 	console.log(this.courseName.nativeElement.value);
	// 	console.log(this.totalLectures.nativeElement.value);
	// 	console.log(this.status.nativeElement.value);
	// }


	update= new FormGroup({
		courseCode: new FormControl(''),
		courseName: new FormControl(''),
		totalLectures: new FormControl(0),
		status: new FormControl(''),
	})

	
	
	courseArr:any[]=[];
	courseDetails:any={};
	onSubmit(){
		console.log(this.update.value);
		this.courseDetails= this.update.value;
		let body={
			courseName: this.update.value.courseName,
			courseCode: this.update.value.courseCode,
			totalLectures: this.update.value.totalLectures,
			status: this.update.value.status
		}
		this.courseService.saveCourses(body).subscribe({
			next: (data) => {console.log(data)},
			error: (err) => {console.log(err)}
		});
	}

	getAllCoursesList(){
		this.courseService.getCoursesList().subscribe({
			next: (data) => {console.log(data); this.courseArr=data},
			error: (err) => {console.log(err)}
		})
	}
	
}
