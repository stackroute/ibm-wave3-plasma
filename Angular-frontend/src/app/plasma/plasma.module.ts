import { UserregistrationComponent } from './components/userregistration/userregistration.component';
import { PlasmaMaterialModule } from './plasma.material.modules';
import { UserLoginComponent } from './components/user-login/user-login.component';
import { CommonModule } from '@angular/common';
import { WebSpeechComponent } from './components/web-speech/web-speech.component';

import { HeaderComponent } from './components/header/header.component';
import {DomainExpertComponent} from './components/domain-expert/domain-expert.component';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';

import { UserLoginService } from './services/user-login.service';

import { AppRoutingModule } from '../app-routing.module';

import { FormsModule } from '@angular/forms';
import { CardComponent } from './components/card/card.component';

@NgModule({
  declarations: [

    HeaderComponent,

    WebSpeechComponent,
    UserregistrationComponent,
    CardComponent
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
    CardComponent,
  ]

})
export class PlasmaModule { }
