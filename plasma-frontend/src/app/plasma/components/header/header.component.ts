import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  route: any;

  constructor() { }

  ngOnInit() {
  }
  profile() {
    this.route.navigate(['/', 'profile']);
  }

}
