import { CardService } from './plasma/services/card.service';
import { PlasmaModule } from './plasma/plasma.module';
import { CardComponent } from './plasma/components/card/card.component';
import { UserLoginComponent } from './plasma/components/user-login/user-login.component';
import { UserLoginService } from './plasma/services/user-login.service';
<<<<<<< HEAD
=======

>>>>>>> 7ea6108266fc9dffab5225da806139e40eb1bb6e
import { PlasmaMaterialModule } from './plasma/plasma.material.modules';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule, FormGroup, ReactiveFormsModule } from '@angular/forms';
<<<<<<< HEAD
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
@NgModule({
declarations: [
  AppComponent,
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
  PlasmaModule ],
providers: [UserLoginService, CardService],
bootstrap: [
  AppComponent
]
=======

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';


import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';


@NgModule({
<<<<<<< HEAD
  declarations: [
    AppComponent,
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
  providers: [UserLoginService, CardService],
  bootstrap: [
    AppComponent
  ]
>>>>>>> 7ea6108266fc9dffab5225da806139e40eb1bb6e
=======
declarations: [
  AppComponent,
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
providers: [UserLoginService, CardService],
bootstrap: [
  AppComponent
]
>>>>>>> fc029eb33221f190f8ddc763ee9d6bbcce5647b9
})
export class AppModule { }
