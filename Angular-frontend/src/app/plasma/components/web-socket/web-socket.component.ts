import { Component } from "@angular/core";
import * as Stomp from "@stomp/stompjs";
import * as SockJS from "sockjs-client";
import * as $ from "jquery";

@Component({
  selector: "app-web-socket",
  templateUrl: "./web-socket.component.html",
  styleUrls: ["./web-socket.component.css"]
})
export class WebSocketComponent {
  serverUrl = "http://localhost:8089/socket";
  title = "WebSockets chat";
  stompClient;
  chatdata;
  topicdata;
  jsondata;

  constructor() {
    this.initializeWebSocketConnection();
  }
  initializeWebSocketConnection() {
    let ws = new SockJS(this.serverUrl);
    this.stompClient = Stomp.over(ws);
    let that = this;
    this.stompClient.connect({}, function(frame) {
      that.stompClient.subscribe("/topic", message => {
        if (message.body) {
          that.chatdata = message.body;
          console.log("data is ", that.chatdata);
          console.log("message body is ", message.body);
        }
      });
    });
  }
  sendMessage(message) {
    this.stompClient.send("/app/data", {}, message);
    $("#input").val("");
    console.log("Inside the send message");
  }
}
