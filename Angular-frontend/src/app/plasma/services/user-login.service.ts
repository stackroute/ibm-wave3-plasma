
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable()
  export class UserLoginService {
  private loginUrl = 'http://localhost:8132/api/user';  // URL to web api

  constructor(private http: HttpClient) { }
  login(user: any): Observable<any> {
    return this.http.post<any>(this.loginUrl, user);
  }

  setCookie(cname: string, cvalue: string, exdays: number) {
    let date = new Date();
    date.setTime(date.getTime() + (exdays * 24 * 60 * 60 * 1000));
    let expires = `expires=${date.toUTCString()}`;
    document.cookie =  `${cname}=${cvalue};${expires};path=/`;
  }

  getCookie(cname: string) {
    let name = cname + '=';
    let ca = document.cookie.split(';');
    for (let i = 0; i < ca.length; i++) {
      let c = ca[i];
      while (c.charAt(0) === '') {
        c = c.substring(1);
      }
      if (c.indexOf(name) === 0) {
        return c.substring(name.length, c.length);
      }
      }
      return '';
      }

      deleteCookie(cname: string) {
        document.cookie = `${cname}=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;`;

      }
    }

