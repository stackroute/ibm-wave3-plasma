// import { WebSocketComponent } from './components/web-socket/web-socket.component';
import { FooterComponent } from './components/footer/footer.component';
import { CardComponent } from './components/card/card.component';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {MatCardModule} from '@angular/material/card';

import { AuthGuard } from './components/auth/auth.guard';
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
import { ProfileComponent } from './components/profile/profile.component';
import { AboutComponent } from './components/about/about.component';
import { Ng2CarouselamosModule } from 'ng2-carouselamos';
import { SpeechRecognizerService } from './services/speech-recognizer.service';

@NgModule({
  declarations: [
    HeaderComponent,
    DomainExpertComponent,
    UserregistrationComponent,
    FooterComponent,
    CardComponent,
    UserLoginComponent,
    ProfileComponent,
    AboutComponent,
    // WebSocketComponent,
    WebSpeechComponent
    ],
  imports: [
   BrowserModule,
   BrowserAnimationsModule,
   AppRoutingModule,
   FormsModule,
   HttpClientModule,
   CommonModule,
   PlasmaMaterialModule,
   ReactiveFormsModule,
   Ng2CarouselamosModule,
   MatCardModule

  ],
  providers: [UserLoginService, SpeechRecognizerService,AuthGuard],
  exports: [
    HeaderComponent,
    DomainExpertComponent,
    UserLoginComponent,
    CardComponent,
    FooterComponent,
    UserregistrationComponent,
    ProfileComponent,
    AboutComponent,
    WebSpeechComponent,
    // WebSocketComponent,
    MatCardModule,
    
  ]
})
export class PlasmaModule { }
