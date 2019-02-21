import { WebSpeechComponent } from './components/web-speech/web-speech.component';

import { HeaderComponent } from './components/header/header.component';
import { NgModule } from '@angular/core';

import { CommonModule } from '@angular/common';
import { PlasmaMaterialModule } from './plasma.material.modules';
import { DomainExpertComponent } from './components/domain-expert/domain-expert.component';


@NgModule({
  declarations: [
    HeaderComponent,
    WebSpeechComponent,
    DomainExpertComponent
  ],
  imports: [
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
