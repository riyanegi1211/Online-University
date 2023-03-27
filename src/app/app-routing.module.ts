import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AssessmentComponent } from './assessment/assessment.component';
import { AnnouncementComponent } from './announcement/announcement.component';

const routes: Routes = [
  {path: "Assessment",component:AssessmentComponent},
  {path: "Announcement",component:AnnouncementComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
