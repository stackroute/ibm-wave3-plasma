import { UserLoginComponent } from './components/user-login/user-login.component';
import { CommonModule } from '@angular/common';
import { WebSpeechComponent } from './components/web-speech/web-speech.component';
import { UserregistrationComponent } from './components/userregistration/userregistration.component';
import { HeaderComponent } from './components/header/header.component';
import {DomainExpertComponent} from './components/domain-expert/domain-expert.component';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { UserLoginService } from './services/user-login.service';
@NgModule({
  declarations: [
    HeaderComponent,
    UserLoginComponent,
    WebSpeechComponent
  ],
  imports: [
    CommonModule,
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,


   BrowserModule,
   BrowserAnimationsModule,
   AppRoutingModule,
   FormsModule,
   HttpClientModule,
   WebSpeechComponent,
   DomainExpertComponent,
   CommonModule,
   PlasmaMaterialModule,
   UserregistrationComponent
  ],
  providers: [UserLoginService],
  exports: [
    HeaderComponent,
    WebSpeechComponent,
    DomainExpertComponent,
    UserLoginComponent,
  ]
  exports: [
   HeaderComponent,
   WebSpeechComponent,
   DomainExpertComponent,
   UserregistrationComponent
 ]
})
export class PlasmaModule { }
