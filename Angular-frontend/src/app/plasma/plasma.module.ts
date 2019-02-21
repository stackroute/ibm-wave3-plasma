import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { WebSpeechComponent } from './components/web-speech/web-speech.component';
import { UserregistrationComponent } from './components/userregistration/userregistration.component';
import { HeaderComponent } from './components/header/header.component';
import {DomainExpertComponent} from './components/domain-expert/domain-expert.component';
@NgModule({
  declarations: [
    HeaderComponent,
    WebSpeechComponent,
    DomainExpertComponent,
    UserregistrationComponent
    ],
  imports: [
    CommonModule,
  ],
  exports: [
   HeaderComponent,
   WebSpeechComponent,
   DomainExpertComponent,
   UserregistrationComponent
 ]
})
export class PlasmaModule { }
