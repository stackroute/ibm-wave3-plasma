import { WebSpeechModule } from './components/web-speech/web-speech.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { WebSpeechComponent } from './components/web-speech/web-speech.component';
import { PlasmaMaterialModule } from './plasma.material.modules';

@NgModule({
  declarations: [WebSpeechComponent],
  imports: [
    CommonModule,
    PlasmaMaterialModule
  ],
  exports: [WebSpeechComponent]
})
export class PlasmaModule { }
