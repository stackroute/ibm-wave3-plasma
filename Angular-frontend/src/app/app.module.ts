import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';


import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { PlasmaMaterialModule } from './plasma/plasma.material.modules';
import { WebSpeechModule } from './plasma/components/web-speech/web-speech.module';
import { HeaderComponent } from './plasma/components/header/header.component';
import { DomainExpertComponent } from './plasma/components/domain-expert/domain-expert.component';
import { UserregistrationComponent } from './plasma/components/userregistration/userregistration.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    DomainExpertComponent,
    UserregistrationComponent

  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    FormsModule,
    WebSpeechModule,
    HttpClientModule,
    PlasmaMaterialModule,
    RouterModule
  ],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule { }
