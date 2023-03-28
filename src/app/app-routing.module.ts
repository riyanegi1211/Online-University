import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AssessmentComponent } from './assessment/assessment.component';
import { AssignmentComponent } from './assignment/assignment.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
  {path: "Home",component:HomeComponent},
  {path: "Assessment",component:AssessmentComponent},
  {path: "Assignment",component:AssignmentComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
