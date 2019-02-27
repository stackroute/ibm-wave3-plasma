import { CardComponent } from './plasma/components/card/card.component';
import { UserLoginComponent } from './plasma/components/user-login/user-login.component';
import { UserLoginService } from './plasma/services/user-login.service';

import { PlasmaMaterialModule } from './plasma/plasma.material.modules';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { ShowHidePasswordModule } from 'ngx-show-hide-password';
import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';


import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { WebSpeechModule } from './plasma/components/web-speech/web-speech.module';
import { DomainExpertComponent } from './plasma/components/domain-expert/domain-expert.component';
import { HeaderComponent } from './plasma/components/header/header.component';
import { UserregistrationComponent } from './plasma/components/userregistration/userregistration.component';

@NgModule({
  declarations: [
    AppComponent,
    DomainExpertComponent,
    HeaderComponent,
    UserregistrationComponent,
    UserLoginComponent,
    CardComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    PlasmaMaterialModule,
    WebSpeechModule,
    RouterModule,
    ReactiveFormsModule,
    ShowHidePasswordModule,

  ],
  providers: [UserLoginService],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule { }
