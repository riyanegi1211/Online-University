import { Component } from '@angular/core';
import { UserService } from '../user.service';
import { Student } from '../Student';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.scss']
})
export class StudentListComponent {
    
    constructor(private userService:UserService){}

    studentArr:Student[]=[];
    getAllStudentsList(){
		this.userService.getStudentList().subscribe({
			next: (data) => {	console.log(data);
                                // for(const x of data)
                                // {
                                //     console.log(x.id);
                                //     this.studentArr.push(x.id);
                                // }
                                this.studentArr=data
                            },
			error: (err) => {console.log(err)}
		})
	}
}
