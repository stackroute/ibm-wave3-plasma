import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Userregister } from '../tsclasses/userregister';

@Injectable({
  providedIn: 'root'
})
export class UserregistrationService {

  url: string;
  response: any;
  get: any;
  profile(emailId: String) {
    this.url = 'http://localhost:8015/api/v1/user/' + emailId;
    return this.http.get(this.url);
   }
constructor(private http: HttpClient ) {
}
 addregister(reg: Userregister) {
   this.url = 'http://localhost:8089/api/v1/user';
  this.http.get(this.url).subscribe(resp => {

  this.response = resp;
      });
  return this.http
  .post(this.url + '', reg, {observe: 'response', responseType: 'text'});
  }
}
