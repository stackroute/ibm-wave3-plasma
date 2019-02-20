
import { WebSpeechModule } from './plasma/components/web-speech/web-speech.module';
import { SharedModule } from './plasma/modules.ts/shared.module';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';

import { HttpClientModule } from '@angular/common/http';
import { DomainExpertComponent } from './plasma/components/domain-expert/domain-expert.component';
import { MaterialModule } from './plasma/plasma.material.modules.ts/material.module';
import { RouterModule } from '@angular/router';
import { UserRegisterComponent } from './plasma/components/user-register/user-register.component';
import { MatSelectModule } from '@angular/material/select';

@NgModule({
  declarations: [
    AppComponent,
    DomainExpertComponent,
    UserRegisterComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    SharedModule,
    WebSpeechModule,
    FormsModule,
    HttpClientModule,
    MaterialModule,
    RouterModule,
    WebSpeechModule,
    MatSelectModule
  ],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule { }
