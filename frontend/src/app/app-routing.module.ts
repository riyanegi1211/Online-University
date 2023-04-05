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
import { CoursecrudComponent } from './coursecrud/coursecrud.component';
import { AuthGuard } from './auth.guard';
import { StudentDashboardComponent } from './student-dashboard/student-dashboard.component';
import { MyhomeComponent } from './myhome/myhome.component';
import { UsercrudComponent } from './usercrud/usercrud.component';

const routes: Routes = [
    { path: '',   redirectTo: '/login', pathMatch: 'full' },
    { path: 'home', component: MyhomeComponent, canActivate: [AuthGuard] },
    { path: 'professor', component: ProfessorComponent },
    { path: 'login', component: LoginComponent },
    { path: 'dashboard', component: StudentDashboardComponent },
    { path: 'admin', component: AdminComponent },
    { path: 'admin/course', component: CoursecrudComponent },
    { path: 'admin/student', component: UsercrudComponent },
    {path: "Assessment",component:AssessmentComponent},
    {path: "Assignment",component:AssignmentComponent},
    {path: "One",component:UnitOneComponent},
    {path: "Two",component:UnitTwoComponent},
    {path: "Three",component:UnitThreeComponent},
    {path: "Four",component:UnitFourComponent},
    {path: "Five",component:UnitFiveComponent}

  ];



@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
