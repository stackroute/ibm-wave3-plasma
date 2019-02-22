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
  exports: [WebSpeechComponent]
=======
  exports: [
   HeaderComponent,
   WebSpeechComponent,
   DomainExpertComponent,
   UserregistrationComponent
 ]
>>>>>>> e24ce893c5b75993d2bc4e99a0b39050f9f2d20d
})
export class PlasmaModule { }
