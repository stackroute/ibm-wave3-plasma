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
<<<<<<< HEAD
import { NgModule } from '@angular/core';
import { UserLoginService } from './services/user-login.service';
@NgModule({
  declarations: [
    HeaderComponent,
    UserLoginComponent,
  ],
  imports: [
    CommonModule,
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
=======
import { AppRoutingModule } from '../app-routing.module';
import { FormsModule } from '@angular/forms';
import { PlasmaMaterialModule } from './plasma.material.modules';
@NgModule({
  declarations: [
    HeaderComponent,
>>>>>>> b3de806f894d0ac41467a42d9b8eb531825324b0
    WebSpeechComponent,
    ],
  imports: [
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
<<<<<<< HEAD
  providers: [UserLoginService],
  exports: [
    HeaderComponent,
    WebSpeechComponent,
    DomainExpertComponent,
    UserLoginComponent,
  ]
=======
<<<<<<< HEAD
  exports: [WebSpeechComponent]
=======
  exports: [
   HeaderComponent,
   WebSpeechComponent,
   DomainExpertComponent,
   UserregistrationComponent
 ]
>>>>>>> e24ce893c5b75993d2bc4e99a0b39050f9f2d20d
>>>>>>> b3de806f894d0ac41467a42d9b8eb531825324b0
})
export class PlasmaModule { }
