import { CardComponent } from './components/card/card.component';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';

import { UserregistrationComponent } from './components/userregistration/userregistration.component';
import { HeaderComponent } from './components/header/header.component';
import { WebSpeechComponent } from './components/web-speech/web-speech.component';
import { AppRoutingModule } from '../app-routing.module';
import { BrowserModule } from '@angular/platform-browser';
import { UserLoginComponent } from './components/user-login/user-login.component';
import { DomainExpertComponent } from './components/domain-expert/domain-expert.component';
import { UserLoginService } from './services/user-login.service';
import { PlasmaMaterialModule } from './plasma.material.modules';
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';


@NgModule({
  declarations: [

    HeaderComponent,

    WebSpeechComponent,
    UserregistrationComponent
    ],
  imports: [
   BrowserModule,

   BrowserAnimationsModule,
   AppRoutingModule,
   FormsModule,
   HttpClientModule,

   CommonModule,
   PlasmaMaterialModule,

  ],
  providers: [UserLoginService],
  exports: [
    HeaderComponent,
    WebSpeechComponent,
    DomainExpertComponent,
    UserLoginComponent,
    CardComponent
  ]
})
export class PlasmaModule { }
