

import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from '@angular/common/http';
// import { BehaviorSubject, throwError } from "rxjs";
// import { catchError } from "rxjs/operators";
@Injectable({
  providedIn: "root"
})
export class SearchService {
  console: any;
 private nlpserviceurl: 'http://localhost:8098/api/v1/query';

  constructor(private http: HttpClient) {
  //   console.log("Hi how are you ");
// this.data();
  }

//    data(finalTranscript: String) {
//      console.log(finalTranscript);
//      return this.http
//      .post(this.nlpserviceurl + 'finalTranscript', String , 'response' );
//    }
getTheData() {
  return this.http.get(`http://localhost:3000/data`);
}

}
