import { WebSpeechModule } from './components/web-speech/web-speech.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { WebSpeechComponent } from './components/web-speech/web-speech.component';
import { PlasmaMaterialModule } from './plasma.material.modules';
import { WebSocketComponent } from './components/web-socket/web-socket.component';

@NgModule({
  declarations: [WebSpeechComponent, WebSocketComponent],
  imports: [
    CommonModule,
    PlasmaMaterialModule
  ],
  exports: [WebSpeechComponent]
})
export class PlasmaModule { }
