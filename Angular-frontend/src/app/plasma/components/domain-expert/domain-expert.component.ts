import { DomainExpertService } from './../../services/domain-expert.service';
import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-domain-expert',
  templateUrl: './domain-expert.component.html',
  styleUrls: ['./domain-expert.component.css']
})
export class DomainExpertComponent implements OnInit {

  constructor(private search: DomainExpertService) {
    console.log('Reading local json files');
    this.search.getTheData().subscribe(data => {
      console.log('is the data comming here ??', data);
    });

  }
  private domain: any;
    private concepts: any [];
  ngOnInit() {
    this.search.getTheData().subscribe((data: any) => {

      this.concepts = data.concepts;
  });
  }
  onClick() {
    console.log({Domain: this.domain});
    console.log({Concepts: this.concepts});
  }
}
