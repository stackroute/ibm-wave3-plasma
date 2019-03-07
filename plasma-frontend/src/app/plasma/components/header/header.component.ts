import { UserLoginService } from './../../services/user-login.service';

import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  route: any;
  userLogged: boolean;
  flag: boolean;

  constructor(private userLoginService: UserLoginService) { }

  ngOnInit() {
    if (localStorage.getItem('token') !== null ) {
      this.flag = true;
     this.userLogged = false;
    } else {   this.flag = false;
     this.userLogged = true;
       }
    } logout() {
        this.userLoginService.logout();
         this.flag = false;
         this.userLogged = true;
  }
  profile() {
    this.route.navigate(['/', 'profile']);
  }

}
