import { UserAuth } from "./../tsclasses/user-auth";

import { HttpClient, HttpErrorResponse } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable, throwError } from "rxjs";
import { catchError } from "rxjs/operators";
import { Router } from "@angular/router";
import { Subject } from "rxjs";

@Injectable()
export class UserLoginService {
  response: any;
  private loginUrl = "http://13.234.94.77:8092/user-login-service/userAuth";
  private errorStatus: string;
  private errorBody: string;
  public checkFlag = new Subject();

  constructor(private http: HttpClient, private router: Router) {
    // this.checkToken();
  }

  // checkToken() {
  //   console.log("is this getting executed ??", localStorage.getItem('token') !== null)
  //   if (localStorage.getItem('token') !== null) {
  //     this.checkFlag.next(true);
  //   } else {
  //     this.checkFlag.next(false);
  //   }
  // }

  login(userAuth: UserAuth) {
    this.checkFlag.next(false);
    return this.http
      .post(this.loginUrl + "", userAuth, { observe: "response" })
      .pipe(catchError(this.handleError));
  }
  logout() {
    console.log("i have entered in the logout function");
    localStorage.removeItem("token");
    this.router.navigate([`/web-speech`]); // after logging out ,it should redirect to homepage
  }
  profile() {
    console.log("i have entered in the logout function");
    // localStorage.removeItem('token');
    this.router.navigate([`/profile`]);
  }
  setCookie(cname: string, cvalue: string, exdays: number) {
    const date = new Date();
    date.setTime(date.getTime() + exdays * 24 * 60 * 60 * 1000);
    const expires = `expires=${date.toUTCString()}`;
    document.cookie = `${cname}=${cvalue};${expires};path=/`;
  }
  getCookie(cname: string) {
    const name = cname + "=";
    const ca = document.cookie.split(";");
    for (let i = 0; i < ca.length; i++) {
      let c = ca[i];
      while (c.charAt(0) === "") {
        c = c.substring(1);
      }
      if (c.indexOf(name) === 0) {
        return c.substring(name.length, c.length);
      }
    }
    return "";
  }

  deleteCookie(cname: string) {
    document.cookie = `${cname}=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;`;
  }
  private handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      console.log("An error occured :", error.error.message);
    } else {
      this.errorStatus = `${error.status}`;
      console.log("Error msg", this.errorStatus);
      this.errorBody = `${error.error}`;
      console.log(
        `Backened returned code ${error.status},` + `body was :${error.error}`
      );
    }
    return throwError(this.errorStatus);
  }
}
