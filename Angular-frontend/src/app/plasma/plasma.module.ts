import { CommonModule } from '@angular/common';
import { WebSpeechComponent } from './components/web-speech/web-speech.component';
import { UserregistrationComponent } from './components/userregistration/userregistration.component';
import { HeaderComponent } from './components/header/header.component';
import {DomainExpertComponent} from './components/domain-expert/domain-expert.component';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from '../app-routing.module';
import { FormsModule } from '@angular/forms';
import { PlasmaMaterialModule } from './plasma.material.modules';

@NgModule({
  declarations: [
    HeaderComponent,
    WebSpeechComponent,
    UserregistrationComponent,
    ],
  imports: [
   BrowserModule,
   BrowserAnimationsModule,
   AppRoutingModule,
   FormsModule,
   HttpClientModule,
  //  WebSpeechComponent,
  //  DomainExpertComponent,
   CommonModule,
   PlasmaMaterialModule,
  //  UserregistrationComponent
  ],
  exports: [
   HeaderComponent,
   WebSpeechComponent,
   DomainExpertComponent,
   UserregistrationComponent
 ]
})
export class PlasmaModule { }
