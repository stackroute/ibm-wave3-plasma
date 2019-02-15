// import { SearchService } from './search.service';
// import { Injectable } from '@angular/core';

// @Injectable({
//   providedIn: 'root'
// })
// export class SearchService {

//   constructor() { }
// }

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
  private nlpserviceurl: 'http://localhost:8098/api/v1/';

  constructor(private http: Http) {
    console.log("Hi how are you ");
    this.getData();

  }

  getData() {
    return this.http.get(this.nlpserviceurl);
  }
}
