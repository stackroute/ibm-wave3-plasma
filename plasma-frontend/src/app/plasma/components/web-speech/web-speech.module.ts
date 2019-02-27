import { FooterComponent } from './../footer/footer.component';
import { SpeechRecognizerService } from './../../services/speech-recognizer.service';



import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { WebSpeechComponent } from './web-speech.component';
import { PlasmaMaterialModule } from '../../plasma.material.modules';


@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    PlasmaMaterialModule,
  ],
  declarations: [
    WebSpeechComponent
  ],
  providers: [
     SpeechRecognizerService,
  ]
})
export class WebSpeechModule { }




