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
    // this.Cardservice.getdoc().subscribe(data => {
    //   this.resp = data ;
    //     console.log('response from getQuiz in card', data);
    // });
    console.log('this is cards component !!');
    this.ws.dataFromTopic.subscribe(({body}) => {
      let loggedInUser = this.helper.decodeToken(localStorage.getItem('token')).jti;
      console.log(JSON.parse(body).userId == loggedInUser,  "LETS CHECK !!!")
      if (JSON.parse(body).userId == loggedInUser) {
        this.cards = JSON.parse(body).documents;
      }else {
        this.check = true;
        // this.message = "User Not Logged In"
      }


      // console.log(JSON.stringify(JSON.parse(body).documents, 1, 1)));
      console.log(JSON.stringify(JSON.parse(body).documents));
    });
  }

}
