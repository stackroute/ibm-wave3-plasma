import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class SearchService {
  console: any;
  private nlpserviceurl: String = 'http://13.234.94.77:8098/api/v1/query';
  url: string;

constructor(private http: HttpClient) {

}
 options = {
   headers: new HttpHeaders({
     'Content-Type': 'text/plain'
   })
 };

data(finalTranscript: String) {
  console.log(this.nlpserviceurl, finalTranscript);
  // return this.http
  // .post(`${this.nlpserviceurl}`, JSON.stringify(finalTranscript), this.options);

  return this.http
  .post(`${this.nlpserviceurl}`, finalTranscript);

}
// profile(userId: String) {
//   this.url = 'http://localhost:8132/api/user/' + userId;
//   return this.http.get(this.url);
//  }

}
