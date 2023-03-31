import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ProfessorComponent } from './professor/professor.component';
import { AdminComponent } from './admin/admin.component';
import { AssessmentComponent } from './assessment/assessment.component';
import { AssignmentComponent } from './assignment/assignment.component';
import { LoginComponent } from './login/login.component';
import { UnitFiveComponent } from './unit-five/unit-five.component';
import { UnitFourComponent } from './unit-four/unit-four.component';
import { UnitOneComponent } from './unit-one/unit-one.component';
import { UnitThreeComponent } from './unit-three/unit-three.component';
import { UnitTwoComponent } from './unit-two/unit-two.component';


const routes: Routes = [
    { path: 'home', component: HomeComponent },
    { path: 'professor', component: ProfessorComponent },
    { path: 'admin', component: AdminComponent },
    { path: 'login', component: LoginComponent },
    { path: '',   redirectTo: '/home', pathMatch: 'full' },
    {path: "Assessment",component:AssessmentComponent},
  {path: "Assignment",component:AssignmentComponent},
    {path: "UnitOne",component:UnitOneComponent},
    {path: "UnitTwo",component:UnitTwoComponent},
    {path: "UnitThree",component:UnitThreeComponent},
    {path: "UnitFour",component:UnitFourComponent},
    {path: "UnitFive",component:UnitFiveComponent}

  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
