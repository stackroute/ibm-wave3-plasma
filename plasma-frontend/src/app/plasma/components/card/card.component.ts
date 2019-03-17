import { CardService } from './../../services/card.service';
import { Component, OnInit } from '@angular/core';
import { WebSocketService } from '../../services/web-socket.service';
import { JwtHelperService } from '@auth0/angular-jwt'

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent implements OnInit {
   private resp: any ;
   cards: any;
   helper = new JwtHelperService();
   message:any;
   check = false;
  constructor( private ws:  WebSocketService) { }
  // public resp;
  ngOnInit() {
    console.log('this is cards component !!');
    this.ws.dataFromTopic.subscribe(({body}) => {
      // let loggedInUser = this.helper.decodeToken(localStorage.getItem('token')).jti;
        this.cards = JSON.parse(body).documents;
       });
  }

}
