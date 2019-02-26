

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class DomainExpertService {
  console: any;
  private searchserviceurl: String = 'http://172.23.239.72:8098/api/v1/search';


constructor(private http: HttpClient) {

}

    getTheData() {
      return this.http.get('http://localhost:3000/data');
    }
}
