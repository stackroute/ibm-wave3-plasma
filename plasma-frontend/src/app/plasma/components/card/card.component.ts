import { CardService } from './../../services/card.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent implements OnInit {
   private resp: any ;
  constructor(private Cardservice: CardService ) { }

  ngOnInit() {
    this.Cardservice.getdoc().subscribe(data => {
      this.resp = data ;
        console.log('response from getQuiz in card', data);
    });
  }

}
