

import { Injectable } from "@angular/core";
import { Http, Response } from '@angular/http';
import {
  HttpClient,
  HttpHeaders,
  HttpErrorResponse
} from "@angular/common/http";
import { BehaviorSubject, throwError } from "rxjs";
import { catchError } from "rxjs/operators";
@Injectable({
  providedIn: "root"
})
export class SearchService {
  console: any;
 private nlpserviceurl: 'http://localhost:8098/api/v1/query';

//   constructor(private http: Http) {
//   //   console.log("Hi how are you ");
// this.data();
//   }

//    data(finalTranscript: String) {
//      console.log(finalTranscript);
//      return this.http
//      .post(this.nlpserviceurl + 'finalTranscript', String , 'response' );
//    }
}
