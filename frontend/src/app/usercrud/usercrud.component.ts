import { Component } from '@angular/core';
import { FormBuilder, FormGroup, FormControl } from '@angular/forms';
import { Student } from '../Student';
import { UserService } from '../user.service';

@Component({
  selector: 'app-usercrud',
  templateUrl: './usercrud.component.html',
  styleUrls: ['./usercrud.component.scss']
})
export class UsercrudComponent {
	constructor(private userService: UserService, private fb:FormBuilder){}
	
	update= new FormGroup({
		studentId: new FormControl(0),
		firstName: new FormControl(''),
		lastName: new FormControl(''),
		studentBranch: new FormControl(''),
		studentSemester: new FormControl(''),
	})

	putOp= new FormGroup({
		studentId: new FormControl(0),
		firstName: new FormControl(''),
		lastName: new FormControl(''),
		studentBranch: new FormControl(''),
		studentSemester: new FormControl(''),
	})
	
	
	studentArr:Student[]=[];
	studentDetails:any={};
	id:number= 0;
	onSubmit(){
		console.log(this.update.value);
		this.studentDetails= this.update.value;
		let body={
			studentId: this.update.value.studentId,
			firstName: this.update.value.firstName,
			lastName: this.update.value.lastName,
			studentBranch: this.update.value.studentBranch,
			studentSemester: this.update.value.studentSemester
		}
		this.userService.saveStudents(body).subscribe({
			next: (data) => {console.log(data)},
			error: (err) => {console.log(err)}
		});
	}

	getAllStudentsList(){
		this.userService.getStudentsList().subscribe({
			next: (data) => {	console.log(data);
                                for(const x of data)
                                {
                                    console.log(x.id);
                                    this.studentArr.push(x.id);
                                }
                                this.studentArr=data
                            },
			error: (err) => {console.log(err)}
		})
	}

	deleteData(delId:number){
		this.userService.deleteData(delId).subscribe({
			next: (data) => {console.log(data)},
			error: (err) => {console.log(err)}
		})
	}
    key:number= 0;
	updateData(updateId:number){
        this.key= updateId;   
	}

    updateCourse(){
        let body={
			studentId: this.putOp.value.studentId,
			firstName: this.putOp.value.firstName,
			lastName: this.putOp.value.lastName,
			studentBranch: this.putOp.value.studentBranch,
			studentSemester: this.putOp.value.studentSemester,
            stuId: this.key
		}
        this.userService.updateStudents(body,body.stuId).subscribe({
            next: (data) => {   console.log(data);
                                this.userService.getStudentsList().subscribe({
                                    next: (data) => {   this.studentArr=data	
                                                        console.log(this.studentArr);
                                                    },
                                    error: (err) => {console.log(err)}
                                })
                            },
            error: (err) => {console.log(err)}
        })
    }
}
