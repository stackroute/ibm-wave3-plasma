import { Component, OnInit } from '@angular/core';
import { UserLoginService } from '../../services/user-login.service';

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
    } else {
      this.flag = false;
     this.userLogged = true;
       }
    }
    logout() {
        this.userLoginService.logout();
         this.flag = false;
      }
  profile() {
    this.userLoginService.profile();
         this.flag = false;
  }

}
