

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class SearchService {
  console: any;
  private nlpserviceurl: String = 'http://localhost:8098/api/v1/query';

constructor(private http: HttpClient) {

}


data(finalTranscript: String) {
  console.log(this.nlpserviceurl, finalTranscript);
  return this.http
  .post( `${this.nlpserviceurl}` , finalTranscript);

}

}
