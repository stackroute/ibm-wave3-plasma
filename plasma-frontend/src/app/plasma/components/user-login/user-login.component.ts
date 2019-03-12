import { UserLogin } from './../../tsclasses/user-login';
import { JwtHelperService } from '@auth0/angular-jwt';
import { UserLoginService } from './../../services/user-login.service';
import { Validators, FormBuilder } from '@angular/forms';
import { Component, Input } from '@angular/core';
import { MatSnackBar } from '@angular/material';
import { Router } from '@angular/router';



@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent {
  isLoggedIn = false ;

  value: string;


@Input()
user: UserLogin;
private userId: string;
private password: string;
  statusCode: number;
  constructor(private fb: FormBuilder, private loginService: UserLoginService, private router: Router, private snackBar: MatSnackBar) {}
  helper = new JwtHelperService();
  login(event: any) {
    this.user = new UserLogin();
    this.user.userId = this.userId;
    this.user.password = this.password;

     console.log(this.user);
    console.log(this.value);
    this.loginService.login(this.user).subscribe((res: any) => {
      console.log('Res: ', res);
      console.log(this.helper.decodeToken(res.body.token).jti, ' :this is the value of the userId');
    console.log(this.helper.decodeToken(res.body.token).sub, ' :this is the value of the role');
    if ((this.helper.decodeToken(res.body.token).sub === 'admin' )) {
      localStorage.setItem('token', res.body.token);
      this.router.navigate([`/admin`]);
      // this.loginService.setCookie('token', res.body.token, 1);
      this.isLoggedIn = true;
    }
    if ((this.helper.decodeToken(res.body.token).sub === 'user' )) {
      localStorage.setItem('token', res.body.token);
      this.router.navigate([`/card`]);
      // this.loginService.setCookie('token', res.body.token, 1);
      this.isLoggedIn = true;
    }


       },
       err => {
        const errorStatus = err;
        this.statusCode = parseInt(errorStatus, 10);
        if (this.statusCode === 401) {
          console.log('user does not exist');
          window.alert('User does not exist');
        }
    });
  }
}

