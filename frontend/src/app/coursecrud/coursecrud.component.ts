import { Component, ElementRef, ViewChild } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { er } from '@fullcalendar/core/internal-common';
import { CourseService } from '../course.service';
// import { error } from 'console';

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

	putOp= new FormGroup({
		courseCode: new FormControl(''),
		courseName: new FormControl(''),
		totalLectures: new FormControl(0),
		status: new FormControl(''),
	})
	
	
	courseArr:any[]=[];
	courseDetails:any={};
	id:number= 0;
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
			next: (data) => {	console.log(data);
								for(const x of data){
									this.id= x.courseId;
								} 
								this.courseArr=data},
			error: (err) => {console.log(err)}
		})
		console.log(this.id);
	}

	deleteData(courseId:number){
		this.courseService.deleteData(courseId).subscribe({
			next: (data) => {console.log(data)},
			error: (err) => {console.log(err)}
		})
	}
    key:number= 0;
	updateData(courseId:number){
		// this.courseService.getCoursesList().subscribe({
		// 	next: (data) => {console.log(data);console.log(this.id)},
		// 	error: (err) => {console.log(err)}
		// })
		// this.courseService.updateCourses(body, this.id).subscribe({
		// 	next: (data) => {console.log(data)},
		// 	error: (err) => {console.log(err)}
		// });
        this.key= courseId;   
	}

    updateCourse(){
        let body={
			courseName: this.update.value.courseName,
			courseCode: this.update.value.courseCode,
			totalLectures: this.update.value.totalLectures,
			status: this.update.value.status
		}
        let id= this.key;
        console.log(id);
        this.courseService.updateCourses(body,id).subscribe({
            next: (data) => {console.log(data)},
            error: (err) => {console.log(err)}
        })
    }
	
}
