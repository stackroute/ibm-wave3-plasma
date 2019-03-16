import { Injectable } from '@angular/core';
import * as Stomp from '@stomp/stompjs';
import * as SockJS from 'sockjs-client';
import {Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class WebSocketService {
  stompClient: Stomp.Client;
  serverUrl: any;
  dataFromTopic = new Subject();

  constructor() {
    console.log("this is getting executed !!")
    this.initializeWebSocketConnection();
  }



  initializeWebSocketConnection() {
    // tslint:disable-next-line:prefer-const
    let ws = new SockJS("http://13.234.94.77:8095/socket");
    this.stompClient = Stomp.over(ws);
    let that = this;
    this.stompClient.connect({}, function(frame) {
      let sessionId = ws._transport.url.split("/")[5];
      console.log(ws._transport.url.split("/")[5], "can we get the session ID ")
      localStorage.setItem('sessionId', ws._transport.url.split("/")[5]);
      that.stompClient.subscribe(`/user/${sessionId}/queue/reply`, message => {
        console.log("MY MESSAGE", message);
          that.dataFromTopic.next(message);
      });
    });
  }



//   sendMessage(message) {
//     this.stompClient.send('/app/data', {}, message);
//     // $("#input").val("");
//     console.log('Inside the send message');
//   }
}
