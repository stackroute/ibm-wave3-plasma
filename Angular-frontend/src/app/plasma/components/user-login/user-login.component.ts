import { UserLoginService } from './../../services/user-login.service';
import { Validators, FormBuilder } from '@angular/forms';
import { Component } from '@angular/core';
import { Router } from '@angular/router';



@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent {
  user = this.fb.group({
    userId: ['', Validators.required],
    password: ['', Validators.required]
  });

  constructor(private fb: FormBuilder, private loginService: UserLoginService, private router: Router) {}
  login() {
    this.loginService.login(this.user.value)
    .subscribe(res => {
      console.log('Res: ', res);
      if (res.message === 'User successfully logged in') {
        this.router.navigate(['/home']);
        this.loginService.setCookie('token', res.token, 1);
      } else {
        window.alert('Invalid credentials');
      }
    });
  }
}

