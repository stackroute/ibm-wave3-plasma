import { UserregistrationService } from './../../services/userregistration.service';
import { Profile } from 'selenium-webdriver/firefox';
import { UserLogin } from './../../tsclasses/user-login';
import { Component, OnInit, Input } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Userregister } from '../../tsclasses/userregister';

import * as jwt_decode from 'jwt-decode';
import * as JWT from 'jwt-decode';
@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  register: any = [];
  @Input()

  loginToken: UserLogin;
  jti: string;

  constructor(private services: UserregistrationService) { }

  ngOnInit() {



    try {
      const tokenObtained = localStorage.getItem('token');
      this.loginToken = jwt_decode(tokenObtained);
      console.log('decoded token', jwt_decode(tokenObtained));
      this.jti = this.loginToken.jti;
      console.log('decoded token id', this.loginToken.jti);
      this.services.profile(this.jti).subscribe(data => {
        // this.reg = data;
        // // console.log(res);
        // console.log( this.reg);
     });
      } catch (error) {
        console.log(error);
      }
    // try {
    //   const tokenObtained = localStorage.getItem('token');
    //   this.loginToken = jwt_decode(tokenObtained);
    //   console.log('decoded token', jwt_decode(tokenObtained));
    //   this.jti = this.loginToken.jti;
    //   console.log('decoded token id', this.loginToken.jti);
    //   this.services.profile(this.).subscribe((res: any) => {
    //     this.reg = res.body;
    //     console.log(res);
    //     console.log( this.reg);
    //  });
    //   } catch (error) {
    //     console.log(error);
    //   }
    //   this.services.profile(this.userId).subscribe((res: any) => {
    //     this.reg = res.body;
    //     console.log(res);
    //     console.log( this.reg);
    //  });
}
}




// this.Userlogin.Profile(this.userId.value)
// .subscribe(res => {
//   console.log('Res: ', res);
