import { UserLoginService } from './plasma/services/user-login.service';
import { WebSpeechModule } from './plasma/components/web-speech/web-speech.module';
import { PlasmaMaterialModule } from './plasma/plasma.material.modules';
import { HeaderComponent } from './plasma/components/header/header.component';

import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';


import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { DomainExpertComponent } from './plasma/components/domain-expert/domain-expert.component';

@NgModule({
  declarations: [
    AppComponent,
    // DomainExpertComponent,
    // HeaderComponent,
    // AppComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    PlasmaMaterialModule,
    WebSpeechModule,
    RouterModule,

  ],
  providers: [UserLoginService],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule { }
