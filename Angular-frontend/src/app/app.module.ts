import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';


import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { PlasmaMaterialModule } from './plasma/plasma.material.modules';
import { WebSpeechModule } from './plasma/components/web-speech/web-speech.module';

@NgModule({
  declarations: [
    AppComponent,

  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    FormsModule,
    WebSpeechModule,
    HttpClientModule,
    PlasmaMaterialModule,
    RouterModule,
  ],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule { }
