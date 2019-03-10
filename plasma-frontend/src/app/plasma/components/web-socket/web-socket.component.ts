import { Component, OnInit } from '@angular/core';
import * as Stomp from '@stomp/stompjs';
import * as SockJS from 'sockjs-client';
@Component({
  selector: 'app-web-socket',
  templateUrl: './web-socket.component.html',
  styleUrls: ['./web-socket.component.css']
})
export class WebSocketComponent {
  serverUrl = 'http://13.234.94.77:8095/socket';
  title = 'WebSockets chat';
  stompClient;
   topicdata;
  constructor() {
    this.initializeWebSocketConnection();
  }

  initializeWebSocketConnection() {
    // tslint:disable-next-line:prefer-const
    let ws = new SockJS(this.serverUrl);
    this.stompClient = Stomp.over(ws);
    let that = this;
    this.stompClient.connect({}, function(frame) {
      that.stompClient.subscribe('/topic', message => {
        if (message.body) {
          that.topicdata = message.body;
          console.log('data is ', that.topicdata);
          console.log('message body is ', message.body);
        }
      });
    });
  }

  sendMessage(message) {
    this.stompClient.send('/app/data', {}, message);
    // $("#input").val("");
    console.log('Inside the send message');
  }
 }
