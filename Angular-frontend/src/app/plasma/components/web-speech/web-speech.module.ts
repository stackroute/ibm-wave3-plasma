import { SpeechRecognizerService } from './../../services/speech-recognizer.service';
// import { NgModule } from '@angular/core';
// import { CommonModule } from '@angular/common';
// import { WebSpeechComponent } from './web-speech.component';

// @NgModule({
//   declarations: [WebSpeechComponent],
//   imports: [
//     CommonModule
//   ]
// })
// export class WebSpeechModule { }

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { WebSpeechComponent } from './web-speech.component';
import { PlasmaMaterialModule } from '../../plasma.material.modules';
import { HeaderComponent } from '../header/header.component';

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




