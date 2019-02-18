
import { WebSpeechModule } from './plasma/web-speech/web-speech.module';
import { SharedModule } from './plasma/modules.ts/shared.module';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';

import { HttpClientModule } from '@angular/common/http';
import { DomainExpertComponent } from './plasma/domain-expert/domain-expert.component';
import { UserRegisterComponent } from './plasma/user-register/user-register.component';

@NgModule({
  declarations: [
    AppComponent,
    DomainExpertComponent,
    UserRegisterComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    SharedModule,
    WebSpeechModule,
    FormsModule,
    HttpClientModule
  ],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule { }
