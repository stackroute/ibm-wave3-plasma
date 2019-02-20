import { Component, OnInit } from '@angular/core';
import { SearchService } from '../../services/search.service';

@Component({
  selector: 'wsa-domain-expert',
  templateUrl: './domain-expert.component.html',
  styleUrls: ['./domain-expert.component.css'],
  providers: [SearchService ]
})
export class DomainExpertComponent implements OnInit {

  constructor(private search: SearchService) {
    console.log('Reading local json files');
    this.search.getTheData().subscribe(data => {
      console.log("is the data comming here ??", data);
    });
  }
    private concepts: any [];
  ngOnInit() {
    this.search.getTheData().subscribe((data: any) => {
      // console.log(data.concepts);
      this.concepts = data.concepts;
  });
  }
}
