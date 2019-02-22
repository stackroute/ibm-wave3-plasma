

import { Injectable } from '@angular/core';
import {
  HttpClient,
  HttpHeaders,
  HttpErrorResponse
} from '@angular/common/http';
import { BehaviorSubject, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
@Injectable({
  providedIn: 'root'
})
export class SearchService {
  console: any;
  private nlpserviceurl: String = 'http://172.23.239.201:8088/api/v1/query';

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
}
