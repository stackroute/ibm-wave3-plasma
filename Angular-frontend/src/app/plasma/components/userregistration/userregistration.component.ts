import { Component, OnInit, Input } from '@angular/core';
import { Userregister } from '../../tsclasses/userregister';
import { HttpClient } from '@angular/common/http';
import { UserregistrationService } from '../../services/userregistration.service';

@Component({
  selector: 'app-userregistration',
  templateUrl: './userregistration.component.html',
  styleUrls: ['./userregistration.component.css']
})
export class UserregistrationComponent implements OnInit {
  value: string;
  @Input()
  private regform: Userregister;
  private name: string;
  private id: string;
  private setPassword: string;
  private contact: string;
  private dateOfBirth: string;
  private gender: string;
  private confirmpassword: string;

  register(event: any) {
    this.regform = new Userregister();
    this.regform.name = this.name;
    this.regform.id = this.id;
    this.regform.setPassword = this.setPassword;
    this.regform.confirmpassword = this.confirmpassword;
    this.regform.contact = this.contact;
    this.regform.dateOfBirth = this.dateOfBirth;
    this.regform.gender = this.gender;

    this.value = event.target.value;
    this.regserv.addregister(this.regform).subscribe(data => {

    });

  }
  constructor(private regserv: UserregistrationService, private http: HttpClient) {

  }

  ngOnInit() {
  }

}
