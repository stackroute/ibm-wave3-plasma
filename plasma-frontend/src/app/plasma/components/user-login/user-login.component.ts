import { UserAuth } from "./../../tsclasses/user-auth";
import { JwtHelperService } from "@auth0/angular-jwt";
import { UserLoginService } from "./../../services/user-login.service";
import { Validators, FormBuilder } from "@angular/forms";
import { Component, Input } from "@angular/core";
import { MatSnackBar } from "@angular/material";
import { Router } from "@angular/router";

@Component({
  selector: "app-user-login",
  templateUrl: "./user-login.component.html",
  styleUrls: ["./user-login.component.css"]
})
export class UserLoginComponent {
  isLoggedIn = false;

  value: string;

  @Input()
  userAuth: UserAuth;
  private userId: string;
  private password: string;
  statusCode: number;
  constructor(
    private fb: FormBuilder,
    private loginService: UserLoginService,
    private router: Router,
    private snackBar: MatSnackBar
  ) {}
  helper = new JwtHelperService();
  login(event: any) {
    this.userAuth = new UserAuth();
    this.userAuth.userId = this.userId;
    this.userAuth.password = this.password;

    //  console.log(this.userAuth);
    // console.log(this.value);
    this.loginService.login(this.userAuth).subscribe(
      (res: any) => {
        this.snackBar.open("User logged in successfully", "", {
          duration: 5000,
          verticalPosition: "bottom"
        });
        //   console.log('Res: ', res);
        //   console.log(this.helper.decodeToken(res.body.token).jti, ' :this is the value of the userId');
        // console.log(this.helper.decodeToken(res.body.token).sub, ' :this is the value of the role');
        if (this.helper.decodeToken(res.body.token).sub === "admin") {
          localStorage.setItem("token", res.body.token);
          this.router.navigate([`/admin`]);
          // this.loginService.setCookie('token', res.body.token, 1);
          this.isLoggedIn = true;
        }
        if (this.helper.decodeToken(res.body.token).sub === "user") {
          localStorage.setItem("token", res.body.token);
          console.log("In login");
          this.router.navigate([`/web-speech`]);
          // this.loginService.setCookie('token', res.body.token, 1);
          this.isLoggedIn = true;
        }
      },
      err => {
        const errorStatus = err;
        this.statusCode = parseInt(errorStatus, 10);
        if (this.statusCode === 401) {
          console.log("userAuth does not exist");
          this.snackBar.open("User does not exist !!!", "", {
            duration: 5000,
            verticalPosition: "bottom"
          });
          // window.alert('user');
        }
      }
    );
  }
}
