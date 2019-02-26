import { DomainExpertService } from './../../services/domain-expert.service';
import { Component, OnInit } from '@angular/core';
import { concat } from 'rxjs/operators';


@Component({
  selector: 'app-domain-expert',
  templateUrl: './domain-expert.component.html',
  styleUrls: ['./domain-expert.component.css']
})
export class DomainExpertComponent implements OnInit {


  constructor(private search: DomainExpertService) {

    // this.search.getTheData().subscribe(data => {
    //   console.log('is the data comming here ??', data);
    // });
    this.search.getTheData().subscribe((data: any) => {
      this.concepts = data.concepts;
  });
  }
  private domain: any;
  private concepts: any[];
  // toppingList: string[] = ['Extra cheese', 'Mushroom', 'Onion', 'Pepperoni', 'Sausage', 'Tomato'];
  selected = -1;
  concept: any[] = [];
  
   onChange(event) {
    console.log(event);
    this.concept.push(event);
 }
  ngOnInit() {

  }
  onClick() {
    console.log({Domain: this.domain});
   // console.log({Concepts: this.concepts});
   console.log(this.concept);
  }
}
