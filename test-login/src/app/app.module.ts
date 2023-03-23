import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HttpClientXsrfModule } from '@angular/common/http';

import { AppComponent } from './app.component';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule
    // ,
    // HttpClientXsrfModule.withOptions({
    //   cookieName: 'app-Xsrf-Cookie',
    //   headerName: 'app-Xsrf-Header',
    //   }),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
