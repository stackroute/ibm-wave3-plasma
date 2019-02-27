import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class SearchService {
  console: any;
  private nlpserviceurl: String = 'http://localhost:8085/api/v1/query';

constructor(private http: HttpClient) {

}
 options = {
   headers: new HttpHeaders({
     'Content-Type': 'text/plain'
   })
 };

data(finalTranscript: String) {
  console.log(this.nlpserviceurl, finalTranscript);
  return this.http
  .post(`${this.nlpserviceurl}`, JSON.stringify(finalTranscript), this.options);

}

}
