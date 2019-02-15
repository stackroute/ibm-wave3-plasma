import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MaterialModule } from '../shared/material/material.module';
import { SpeechRecognizerService } from './shared/services/speech-recognizer.service';
import { WebSpeechComponent } from './web-speech.component';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    MaterialModule
  ],
  declarations: [
    WebSpeechComponent
  ],
  providers: [
    SpeechRecognizerService

  ]
})
export class WebSpeechModule { }
