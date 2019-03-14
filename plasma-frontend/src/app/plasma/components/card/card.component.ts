import { CardService } from './../../services/card.service';
import { Component, OnInit } from '@angular/core';
import { WebSocketService } from '../../services/web-socket.service';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent implements OnInit {
   private resp: any ;
   cards: any;
  constructor( private ws:  WebSocketService) { }
  // public resp;
  ngOnInit() {
    // this.Cardservice.getdoc().subscribe(data => {
    //   this.resp = data ;
    //     console.log('response from getQuiz in card', data);
    // });
    console.log('this is cards component !!');
    this.ws.dataFromTopic.subscribe(({body}) => {
      this.cards = JSON.parse(body).documents;
      // console.log(JSON.stringify(JSON.parse(body).documents, 1, 1)));
      console.log(JSON.stringify(JSON.parse(body).documents));
    });
  }

}
