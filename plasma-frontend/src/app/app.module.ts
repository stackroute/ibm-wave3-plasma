import { CardService } from './plasma/services/card.service';
import { PlasmaModule } from './plasma/plasma.module';
import { CardComponent } from './plasma/components/card/card.component';
import { UserLoginComponent } from './plasma/components/user-login/user-login.component';
import { UserLoginService } from './plasma/services/user-login.service';

import { PlasmaMaterialModule } from './plasma/plasma.material.modules';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule, FormGroup, ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';


import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { UserregistrationService } from './plasma/services/userregistration.service';
import { WebSocketComponent } from './plasma/components/web-socket/web-socket.component';


@NgModule({
declarations: [
  AppComponent,
  WebSocketComponent
],
imports: [
  BrowserModule,
  BrowserAnimationsModule,
  AppRoutingModule,
  FormsModule,
  HttpClientModule,
  PlasmaMaterialModule,
  RouterModule,
  ReactiveFormsModule,
  PlasmaModule

],
providers: [UserLoginService, CardService, UserregistrationService],
bootstrap: [
  AppComponent
]
})
export class AppModule { }
