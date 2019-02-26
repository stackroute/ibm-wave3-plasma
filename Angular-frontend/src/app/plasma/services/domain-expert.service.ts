

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Domainexpert} from '../tsclasses/domainexpert';

@Injectable({
  providedIn: 'root'
})
export class DomainExpertService {
  url: string;
  response: any;
  get: any;
  console: any;
  // private searchserviceurl: String = 'http://172.23.239.72:8098/api/v1/search';


constructor(private http: HttpClient) {

}

    getTheData() {
      return this.http.get('http://localhost:3000/data');
    }
    add(reg: Domainexpert) {
      this.url = 'http://localhost:8091/api/v1/search';
      // this.http.get(this.url + '').subscribe(resp => {
          // console.log(resp);
      // this.response = resp;
      //     });
      return this.http.post(this.url + '', reg, {observe: 'response', responseType: 'text'});
    }
}
