import { from } from 'rxjs';
import { JwtHelperService } from '@auth0/angular-jwt';
import { CardService } from './../../services/card.service';

import { SearchService } from '../../services/search.service';

import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { SpeechRecognizerService } from '../../services/speech-recognizer.service';

import { SpeechNotification } from '../../tsclasses/speech-notification';
import { SpeechError } from '../../tsclasses/speech-error';

import { Router } from '@angular/router';
import * as jwt_decode from 'jwt-decode';
import * as search from '../../tsclasses/search';

import { WebSocketService } from '../../services/web-socket.service';

@Component({
 selector: 'app-web-speech',
 templateUrl: './web-speech.component.html',
 styleUrls: ['./web-speech.component.css']
})
export class WebSpeechComponent implements OnInit {
 finalTranscript = '';
 recognizing = false;
 notification: string;
 loginToken: search.search;
 reg: any;
 jti: String;



 constructor(
   private changeDetector: ChangeDetectorRef,
   private speechRecognizer: SpeechRecognizerService,
   private searchService: SearchService,
   private router: Router,
   private Cardservice: CardService,
   private ws: WebSocketService
 ) { }

 ngOnInit() {

   this.initRecognition();
   this.notification = null;
 }

 onClickMe(data) {
   if (data !== undefined || data !== null ) {
   this.finalTranscript = data;
 }
   this.Cardservice.getdoc().subscribe(resp => {
     console.log('response from call', resp);
   });
  // tslint:disable-next-line:no-shadowed-variable
  this.searchService.data(this.finalTranscript).subscribe(data => {
    console.log(data);
  });
  this.router.navigateByUrl('/card');
  }
 startButton(event) {
   if (this.recognizing) {
     this.speechRecognizer.stop();
     return;
   }

   this.speechRecognizer.start(event.timeStamp);
 }



 private initRecognition() {
   this.speechRecognizer.onStart().subscribe(data => {
     this.recognizing = true;

     this.notification = '';
     this.detectChanges();
   });

   this.speechRecognizer.onEnd().subscribe(data => {
     this.recognizing = false;
     this.detectChanges();
     this.notification = null;
   });

   this.speechRecognizer.onResult().subscribe((data: SpeechNotification) => {
     const message = data.content.trim();
     if (data.info === 'final_transcript' && message.length > 0) {
       this.finalTranscript = `${this.finalTranscript}\n${message}`;
       this.detectChanges();

     }
   });

   this.speechRecognizer.onError().subscribe(data => {
     switch (data.error) {
       case SpeechError.BLOCKED:
       case SpeechError.NOT_ALLOWED:
         this.notification = `Cannot run the demo.
           Your browser is not authorized to access your microphone. Verify that your browser has access to your microphone and try again.
           `;
         break;
       case SpeechError.NO_SPEECH:
         this.notification = `No speech has been detected. Please try again.`;
         break;
       case SpeechError.NO_MICROPHONE:
         this.notification = `Microphone is not available. Plese verify the connection of your microphone and try again.`;
         break;
       default:
         this.notification = null;
         break;
     }
     this.recognizing = false;
     this.detectChanges();
   });
 }

 detectChanges() {
   this.changeDetector.detectChanges();
 }

}
