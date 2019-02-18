import { Injectable, Input } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable({
   providedIn: 'root'
})
export class UserRegisterService {
   url: string;
   response: any;
   get: any;
constructor(private http: HttpClient ) {}
  register(searchText: string) {
   this.http.get('http://localhost:8089/api/v1/user').subscribe(resp => {
       console.log(resp);
   this.response = resp;
       });
   return this.response;
   }
}
