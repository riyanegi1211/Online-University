import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MdbAccordionModule } from 'mdb-angular-ui-kit/accordion';
import { MdbCarouselModule } from 'mdb-angular-ui-kit/carousel';
import { MdbCheckboxModule } from 'mdb-angular-ui-kit/checkbox';
import { MdbCollapseModule } from 'mdb-angular-ui-kit/collapse';
import { MdbDropdownModule } from 'mdb-angular-ui-kit/dropdown';
import { MdbFormsModule } from 'mdb-angular-ui-kit/forms';
import { MdbModalModule } from 'mdb-angular-ui-kit/modal';
import { MdbPopoverModule } from 'mdb-angular-ui-kit/popover';
import { MdbRadioModule } from 'mdb-angular-ui-kit/radio';
import { MdbRangeModule } from 'mdb-angular-ui-kit/range';
import { MdbRippleModule } from 'mdb-angular-ui-kit/ripple';
import { MdbScrollspyModule } from 'mdb-angular-ui-kit/scrollspy';
import { MdbTabsModule } from 'mdb-angular-ui-kit/tabs';
import { MdbTooltipModule } from 'mdb-angular-ui-kit/tooltip';
import { MdbValidationModule } from 'mdb-angular-ui-kit/validation';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatToolbarModule} from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import {MatSidenavModule} from '@angular/material/sidenav';
import { MatNativeDateModule } from '@angular/material/core';
import {MatListModule} from '@angular/material/list';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HomeComponent } from './home/home.component';
import { FullCalendarModule } from '@fullcalendar/angular';
import { FooterComponent } from './footer/footer.component';
import { ProfessorComponent } from './professor/professor.component';
import { AdminComponent } from './admin/admin.component';
import { FormsModule } from '@angular/forms';
import { NgChartsModule } from 'ng2-charts';
import { HttpClientModule } from '@angular/common/http';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { LoginComponent } from './login/login.component';
import { StudentDashboardComponent } from './student-dashboard/student-dashboard.component';
import { AnnouncementComponent } from './announcement/announcement.component';
import { AssessmentComponent } from './assessment/assessment.component';
import { AssignmentComponent } from './assignment/assignment.component';
import { CourseOverviewComponent } from './course-overview/course-overview.component';
import { SideNavComponent } from './side-nav/side-nav.component';

@NgModule({
  declarations: [
	AppComponent,
	HomeComponent,
 FooterComponent,
 ProfessorComponent,
 AdminComponent,
 LoginComponent,
 StudentDashboardComponent,
 AnnouncementComponent,
 AssessmentComponent,
 AssignmentComponent,
 CourseOverviewComponent,
 SideNavComponent
  ],
  imports: [
	BrowserModule,
	AppRoutingModule,
	MdbAccordionModule,
	MdbCarouselModule,
	MdbCheckboxModule,
	MdbCollapseModule,
	MdbDropdownModule,
	MdbFormsModule,
	MdbModalModule,
	MdbPopoverModule,
	MdbRadioModule,
	MdbRangeModule,
	MdbRippleModule,
	MdbScrollspyModule,
	MdbTabsModule,
	MdbTooltipModule,
	MdbValidationModule,
	BrowserAnimationsModule,
	MatToolbarModule,
	MatIconModule,
	MatSidenavModule,
	MatNativeDateModule,
	MatListModule,
	NgbModule,
	FullCalendarModule,
    FormsModule,
    NgChartsModule,
    HttpClientModule,
    FontAwesomeModule
  ],
  entryComponents: [AppComponent],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
