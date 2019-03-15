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
   this.url = 'http://13.234.94.77:3000/plasma';
   console.log('response from server', this.http.get(this.url));
   return this.http.get(this.url);
  }

}
