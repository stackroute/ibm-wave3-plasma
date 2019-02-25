import { UserLogin } from './../../tsclasses/user-login';
import { UserLoginService } from './../../services/user-login.service';
import { Validators, FormBuilder } from '@angular/forms';
import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';



@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent {
  // user = this.fb.group({
  //   userId: ['', Validators.required],
  //   password: ['', Validators.required]
  // });
  value: string;
@Input()
user: UserLogin;
private userId: string;
private password: string;
  statusCode: number;
  constructor(private fb: FormBuilder, private loginService: UserLoginService, private router: Router) {}
  login(event: any) {
    this.user = new UserLogin();
    this.user.userId = this.userId;
    this.user.password = this.password;
    // this.value = event.target.value;
     console.log(this.user);
    console.log(this.value);
    this.loginService.login(this.user).subscribe(res => {
      console.log('Res: ', res);
      // if (res.message === 'User successfully logged in') {
      //   this.router.navigate(['/home']);
      //   this.loginService.setCookie('token', res.token, 1);
      // } else {
      //   window.alert('Invalid credentials');
       },
       err => {
        const errorStatus = err;
        this.statusCode = parseInt(errorStatus, 10);
        if (this.statusCode === 401) {
          console.log('user does not exist');
          this.statusCode = 0;
        }
    });
  }
}

