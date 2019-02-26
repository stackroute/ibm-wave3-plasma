import { DomainExpertService } from './../../services/domain-expert.service';
import { Component, OnInit, Input } from '@angular/core';
import { Domainexpert } from '../../tsclasses/domainexpert';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-domain-expert',
  templateUrl: './domain-expert.component.html',
  styleUrls: ['./domain-expert.component.css']
})
export class DomainExpertComponent implements OnInit {
  value: string;
  @Input()
  private regform: Domainexpert;
  private domain: string;
  private concept: string[];
  // private domain: any;
  private concepts: any [];

  constructor(private search: DomainExpertService, private http: HttpClient) {
    console.log('Reading local json files');
    this.search.getTheData().subscribe(data => {
      console.log('is the data comming here ??', data);
    });

  }

  ngOnInit() {
    this.search.getTheData().subscribe((data: any) => {

      this.concepts = data.concepts;
  });
  // console.log(this.regform);
  }

   send(event: Domainexpert) {
    // this.regform = new Domainexpert();
    // this.regform.domain = 'java';
    // this.regform.concept = ['encapsulation'];
   // this.value = event.target.value;
   console.log('durga');
    console.log(this.concept);
    console.log(this.regform);
    console.log('hello');
    this.search.add(this.regform).subscribe(data => {
    });

   }
  onClick() {
    console.log({Domain: this.domain});
     console.log({Concepts: this.concepts});

  }
  // ngOnInit() {
  // }

}
