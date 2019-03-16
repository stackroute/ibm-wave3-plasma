import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject, Observable } from 'rxjs';

@Injectable()
export class CardService {
   url: any;
   response: any;
     constructor(private http: HttpClient) {
   }
  getdoc() {
   this.url = 'http://localhost:3000/plasma';
   console.log('response from jsonr', this.http.get(this.url));
   return this.http.get(this.url);
  }

}
