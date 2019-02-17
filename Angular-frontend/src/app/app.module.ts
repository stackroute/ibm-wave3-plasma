
import { WebSpeechModule } from './plasma/web-speech/web-speech.module';
import { SharedModule } from './plasma/modules.ts/shared.module';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
<<<<<<< HEAD:Speech to text Angular/src/app/app.module.ts
import { SharedModule } from './shared/shared.module';
import { WebSpeechModule } from './web-speech/web-speech.module';
import { HttpClientModule } from '@angular/common/http';
import { UserRegisterServiceModule } from './userregister/userregisterservice.module';
=======
>>>>>>> f719488db96299f03ad0f772af047743b3dee7fd:Angular-frontend/src/app/app.module.ts

import { HttpClientModule } from '@angular/common/http';
import { DomainExpertComponent } from './plasma/domain-expert/domain-expert.component';

@NgModule({
  declarations: [
    AppComponent,
    DomainExpertComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    SharedModule,
    WebSpeechModule,
    FormsModule,
    HttpClientModule,
    UserRegisterServiceModule
  ],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule { }
