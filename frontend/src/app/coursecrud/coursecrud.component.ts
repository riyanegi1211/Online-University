import { Component, ElementRef, ViewChild } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { er } from '@fullcalendar/core/internal-common';
import { CourseService } from '../course.service';
import { Course } from '../Course';
// import { error } from 'console';

@Component({
  selector: 'app-coursecrud',
  templateUrl: './coursecrud.component.html',
  styleUrls: ['./coursecrud.component.scss']
})
export class CoursecrudComponent {

	constructor(private courseService: CourseService, private fb:FormBuilder){}
	
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
	
	
	courseArr:Course[]=[];
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
                                for(const x of data)
                                {
                                    this.courseArr.push(x.courseId);
                                }
								this.courseArr=data
                            },
			error: (err) => {console.log(err)}
		})
	}

	deleteData(courseId:number){
		this.courseService.deleteData(courseId).subscribe({
			next: (data) => {console.log(data)},
			error: (err) => {console.log(err)}
		})
	}
    key:number= 0;
	updateData(courseId:number){
        this.key= courseId;   
	}

    updateCourse(){
        let body={
			courseName: this.putOp.value.courseName,
			courseCode: this.putOp.value.courseCode,
			totalLectures: this.putOp.value.totalLectures,
			status: this.putOp.value.status,
            courseId: this.key
		}
        this.courseService.updateCourses(body,body.courseId).subscribe({
            next: (data) => {   console.log(data);
                                this.courseService.getCoursesList().subscribe({
                                    next: (data) => {   this.courseArr=data	
                                                        console.log(this.courseArr);
                                                    },
                                    error: (err) => {console.log(err)}
                                })
                            },
            error: (err) => {console.log(err)}
        })
    }
	
}
