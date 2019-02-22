

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class SearchService {
  console: any;
  private nlpserviceurl: String = 'http://172.23.239.201:8079/api/v1/query';

  constructor(private http: HttpClient) {
  console.log('Hi how are you ');

  }

//    data(finalTranscript: String) {
//      console.log(finalTranscript);
//      return this.http
//      .post(this.nlpserviceurl + 'finalTranscript', String);
//    }
data(finalTranscript: String) {
  console.log('asydoyds' + finalTranscript);
  console.log(this.nlpserviceurl, finalTranscript);
  return this.http
  .post( `${this.nlpserviceurl}` , finalTranscript);

}
    getTheData() {
      return this.http.get('http://localhost:3000/data');
    }
}
