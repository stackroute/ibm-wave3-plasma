import { WebSpeechModule } from './components/web-speech/web-speech.module';
import { FooterComponent } from './components/footer/footer.component';
import { CardComponent } from './components/card/card.component';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
<<<<<<< HEAD
import { UserregistrationComponent } from './components/userregistration/userregistration.component';
import { HeaderComponent } from './components/header/header.component';
=======

import { UserregistrationComponent } from './components/userregistration/userregistration.component';
import { HeaderComponent } from './components/header/header.component';
import { WebSpeechComponent } from './components/web-speech/web-speech.component';
>>>>>>> 7ea6108266fc9dffab5225da806139e40eb1bb6e
import { AppRoutingModule } from '../app-routing.module';
import { BrowserModule } from '@angular/platform-browser';
import { UserLoginComponent } from './components/user-login/user-login.component';
import { DomainExpertComponent } from './components/domain-expert/domain-expert.component';
import { UserLoginService } from './services/user-login.service';
import { PlasmaMaterialModule } from './plasma.material.modules';
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
<<<<<<< HEAD
@NgModule({
 declarations: [
   HeaderComponent,
   DomainExpertComponent,
   UserregistrationComponent,
   FooterComponent,
   CardComponent,
   UserLoginComponent
   ],
 imports: [
  BrowserModule,
  BrowserAnimationsModule,
  AppRoutingModule,
  FormsModule,
  HttpClientModule,
  CommonModule,
  PlasmaMaterialModule,
  WebSpeechModule  ],
 providers: [UserLoginService],
 exports: [
   HeaderComponent,
   DomainExpertComponent,
   UserLoginComponent,
   CardComponent,
   FooterComponent,
   UserregistrationComponent
 ]
=======


@NgModule({
<<<<<<< HEAD
 declarations: [
   HeaderComponent,
   DomainExpertComponent,
   UserregistrationComponent,
   FooterComponent,
   CardComponent,
   UserLoginComponent
   ],
 imports: [
  BrowserModule,
  BrowserAnimationsModule,
  AppRoutingModule,
  FormsModule,
  HttpClientModule,
  CommonModule,
  PlasmaMaterialModule,
  WebSpeechModule

 ],
 providers: [UserLoginService],
 exports: [
   HeaderComponent,
   DomainExpertComponent,
   UserLoginComponent,
   CardComponent,
   FooterComponent,
   UserregistrationComponent
 ]
=======
  declarations: [
    HeaderComponent,
    DomainExpertComponent,
    UserregistrationComponent,
    FooterComponent,
    CardComponent,
    UserLoginComponent
    ],
  imports: [
   BrowserModule,
   BrowserAnimationsModule,
   AppRoutingModule,
   FormsModule,
   HttpClientModule,
   CommonModule,
   PlasmaMaterialModule,
   WebSpeechModule

  ],
  providers: [UserLoginService],
  exports: [
    HeaderComponent,
    DomainExpertComponent,
    UserLoginComponent,
    CardComponent,
    FooterComponent,
    UserregistrationComponent
  ]
>>>>>>> 7ea6108266fc9dffab5225da806139e40eb1bb6e
})
export class PlasmaModule { }
