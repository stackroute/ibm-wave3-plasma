import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { JwtHelperService } from "@auth0/angular-jwt";
@Injectable({
  providedIn: 'root'
})
export class SearchService {
  console: any;
  private nlpserviceurl: String = 'http://13.234.94.77:8092/nlp-service';
  url: string;

constructor(private http: HttpClient) {

}

 helper = new JwtHelperService();

 options = {
   headers: new HttpHeaders({
     'Content-Type': 'application/json'
   })
 };

data(finalTranscript: String) {

  const decodedToken = this.helper.decodeToken(localStorage.getItem('token'));
  let requestBody = {
    // "userId" : decodedToken.jti,  
    "userQuery" : finalTranscript,
    // "jwt" : localStorage.getItem('token'),
    // "role" : decodedToken.sub,
    "sessionId": localStorage.getItem('sessionId')
  }

 console.log(decodedToken, "this is the token data ")
  return this.http.post(`${this.nlpserviceurl}`, requestBody);

}

}
