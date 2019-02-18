
import { WebSpeechModule } from './plasma/components/web-speech/web-speech.module';
import { SharedModule } from './plasma/modules.ts/shared.module';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';

import { HttpClientModule } from '@angular/common/http';
import { DomainExpertComponent } from './plasma/domain-expert/domain-expert.component';
import { UserRegisterServiceModule } from './plasma/userregister/userregisterservice.module';

@NgModule({
  declarations: [
    AppComponent,
    DomainExpertComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    SharedModule,
    WebSpeechModule,
    FormsModule,
    HttpClientModule,
    UserRegisterServiceModule
  ],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule { }
