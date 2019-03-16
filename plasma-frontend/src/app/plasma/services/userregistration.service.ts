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
  profile(userId: String) {
    this.url = 'http://13.234.94.77:8092/user-login-service/user' + userId;
    return this.http.get(this.url);
   }
constructor(private http: HttpClient ) {
} 
 addregister(reg: Userregister) {
  this.url = 'http://13.234.94.77:8092/user-register-service';
  this.http.get(this.url).subscribe(resp => {

  this.response = resp;
      });
  return this.http
  .post(this.url + '', reg, {observe: 'response', responseType: 'text'});
  }
}
