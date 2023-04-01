import { Component } from '@angular/core';
import { StudentServiceService } from '../student-service.service';

@Component({
  selector: 'app-unit-one',
  templateUrl: './unit-one.component.html',
  styleUrls: ['./unit-one.component.scss']
})
export class UnitOneComponent {
   
    constructor(private studentService: StudentServiceService){}
    lectureUpdate(){
        this.studentService.updateCourseInfo().subscribe({
            next: (data) => {console.log(data)},
            error: (err) => {console.log(err)}
        })
    }
}
