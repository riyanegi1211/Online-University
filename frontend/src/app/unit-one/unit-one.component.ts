import { Component } from '@angular/core';

@Component({
  selector: 'app-unit-one',
  templateUrl: './unit-one.component.html',
  styleUrls: ['./unit-one.component.css']
})
export class UnitOneComponent {
	// (id:int, link string, desc:string, checked bo)
	cid:number= 19021905;
	unit1Lectures=[
		{id: 1, link: "https://youtu.be/oZ-ZIhJyy9o", desc: "Time Complexity"},
		{id: 2, link: "https://youtu.be/oSQbwlepoCU", desc: "Basics"},
		{id: 3, link: "https://youtu.be/7F3MYyw3Jmg", desc: "Advance"},
		{id: 4, link: "https://youtu.be/j9RG18jfnRY", desc: "Must Practice Problems"},
		{id: 5, link: "https://youtu.be/9rt-hFcXd0M", desc: "Advance Concepts Part-1"},
	]
	
	constructor(private studentService: StudentServiceService){}
	lectureUpdate(key:any){
		this.studentService.updateCourseInfo(key,this.cid).subscribe({
			next: (data) => {console.log(data)},
			error: (err) => {console.log(err)}
		})
	}
}
