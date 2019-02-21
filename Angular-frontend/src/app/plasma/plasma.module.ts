import { WebSpeechComponent } from './components/web-speech/web-speech.component';

import { HeaderComponent } from './components/header/header.component';
import { NgModule } from '@angular/core';

import { CommonModule } from '@angular/common';
import { PlasmaMaterialModule } from './plasma.material.modules';
import { DomainExpertComponent } from './components/domain-expert/domain-expert.component';


=======

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
>>>>>>> 77b298e7f7444d8d996348b16c14d49fd43fb86e
@NgModule({
  declarations: [
    HeaderComponent,
    WebSpeechComponent
  ],
  imports: [

    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
>>>>>>> 77b298e7f7444d8d996348b16c14d49fd43fb86e
    WebSpeechComponent,
    DomainExpertComponent
  ],
  imports: [
     CommonModule,
     PlasmaMaterialModule
  ],
  exports: [
    HeaderComponent,
    WebSpeechComponent,
    DomainExpertComponent
  ]
})
 
  exports: [HeaderComponent, WebSpeechComponent]
  // bootstrap: [
  //   AppComponent
  // ]
 }) 
export class PlasmaModule { }
