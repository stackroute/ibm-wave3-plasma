import { CommonModule } from '@angular/common';
import { PlasmaMaterialModule } from './plasma.material.modules';
import { DomainExpertComponent } from './components/domain-expert/domain-expert.component';


import { HeaderComponent } from './components/header/header.component';
import { WebSpeechComponent } from '../plasma/components/web-speech/web-speech.component';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from '../app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
@NgModule({
  declarations: [
    HeaderComponent,
    WebSpeechComponent
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
    PlasmaMaterialModule
  ],
  exports: [
    HeaderComponent,
    WebSpeechComponent,
    DomainExpertComponent
  ]
})
export class PlasmaModule { }
