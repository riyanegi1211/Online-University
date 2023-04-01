import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AssessmentComponent } from './assessment/assessment.component';
import { AssignmentComponent } from './assignment/assignment.component';
import { HomeComponent } from './home/home.component';
import { UnitFiveComponent } from './unit-five/unit-five.component';
import { UnitFourComponent } from './unit-four/unit-four.component';
import { UnitOneComponent } from './unit-one/unit-one.component';
import { UnitThreeComponent } from './unit-three/unit-three.component';
import { UnitTwoComponent } from './unit-two/unit-two.component';

const routes: Routes = [
  {path: "Home",component:HomeComponent},
  {path: "Assessment",component:AssessmentComponent},
  {path: "Assignment",component:AssignmentComponent},
  {path: "One",component:UnitOneComponent},
  {path: "Two",component:UnitTwoComponent},
  {path: "Four",component:UnitFourComponent},
  {path: "Three",component:UnitThreeComponent},
  {path: "Five",component:UnitFiveComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
