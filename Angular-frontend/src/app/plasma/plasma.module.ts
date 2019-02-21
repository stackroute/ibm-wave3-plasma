
import { HeaderComponent } from './components/header/header.component';
import { WebSpeechComponent } from '../plasma/components/web-speech/web-speech.component';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from '../app-routing.module';

import { AppComponent } from '../app.component';


import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

import { WebSpeechModule } from './components/web-speech/web-speech.module';
 import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
// import { WebSpeechComponent } from './components/web-speech/web-speech.component';
import { PlasmaMaterialModule } from './plasma.material.modules';
// import { UserLoginComponent } from './components/user-login/user-login.component';
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    WebSpeechComponent
  ],
  imports: [

    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    WebSpeechComponent,
    RouterModule,
  ],
  exports: [HeaderComponent, WebSpeechComponent]
  // bootstrap: [
  //   AppComponent
  // ]
 })
export class PlasmaModule { }
