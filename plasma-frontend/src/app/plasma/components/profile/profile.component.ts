import { UserregistrationService } from './../../services/userregistration.service';
import { Profile } from 'selenium-webdriver/firefox';
import { UserAuth } from './../../tsclasses/user-auth';
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
  reg: any;
  loginToken: UserAuth;
  jti: any;

  constructor(private services: UserregistrationService, private router: Router) { }

  ngOnInit() {
    try {
      const tokenObtained = localStorage.getItem('token');
      this.loginToken = jwt_decode(tokenObtained);
      console.log('decoded token', jwt_decode(tokenObtained));
      this.jti = this.loginToken.jti;
      console.log('decoded token id', this.loginToken.jti);
      this.services.profile(this.jti).subscribe(data => {
        this.reg = data;
        // console.log(res);
        console.log( this.reg);
     });
      } catch (error) {
        console.log(error);
      }
}
}
