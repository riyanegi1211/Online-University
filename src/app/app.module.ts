import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatButtonModule } from '@angular/material/button';
import { MatListModule } from '@angular/material/list';
import { MatIconModule } from '@angular/material/icon';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatCardModule} from '@angular/material/card';
import { MatInputModule} from '@angular/material/input';
import { FormsModule } from '@angular/forms';
import { AssessmentComponent } from './assessment/assessment.component';
import { AngularFileUploaderModule } from "angular-file-uploader";
import { HomeComponent } from './home/home.component';
import { AssignmentComponent } from './assignment/assignment.component';
import { UnitOneComponent } from './unit-one/unit-one.component';
import { UnitTwoComponent } from './unit-two/unit-two.component';
import { UnitThreeComponent } from './unit-three/unit-three.component';
import { UnitFourComponent } from './unit-four/unit-four.component';
import { UnitFiveComponent } from './unit-five/unit-five.component';



@NgModule({
  declarations: [
    AppComponent,
    AssessmentComponent,
    HomeComponent,
    AssignmentComponent,
    UnitOneComponent,
    UnitTwoComponent,
    UnitThreeComponent,
    UnitFourComponent,
    UnitFiveComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    AngularFileUploaderModule,
    BrowserAnimationsModule,
    HttpClientModule,
    FormsModule,
    MatExpansionModule,
    MatToolbarModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatToolbarModule,
    MatSidenavModule,

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { 
 
}
