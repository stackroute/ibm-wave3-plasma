

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



constructor(private http: HttpClient) {

}

    getTheData() {
      return this.http.get('http://localhost:3000/data');
    }
    add(reg: Domainexpert) {
      this.url = 'http://localhost:8091/api/v1/search';

      return this.http.post(this.url + '', reg, {observe: 'response', responseType: 'text'});
    }
}
