import { Component, OnInit, Input } from '@angular/core';
import { Userregister } from '../../tsclasses/userregister';
import { HttpClient } from '@angular/common/http';
import { UserregistrationService } from '../../services/userregistration.service';
import {FormControl, FormGroupDirective, NgForm, Validators} from '@angular/forms';
import {ErrorStateMatcher} from '@angular/material/core';

export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const isSubmitted = form && form.submitted;
    return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
  }
}

@Component({
  selector: 'app-userregistration',
  templateUrl: './userregistration.component.html',
  styleUrls: ['./userregistration.component.css']
})
export class UserregistrationComponent implements OnInit {
  value: string;
  hide = true;
  @Input()
  private regform;
  private name: string;
  // private id: string;
  private password: string;
  private contact: Number;
  private dateOfBirth: string;
  private gender: string;
  // private confirmpassword: string;
  private emailId: string;
  matcher = new MyErrorStateMatcher();


  emailFormControl = new FormControl('', [
    Validators.required,
    Validators.email,
  ]);

  register(event: any) {
    this.regform = new Userregister();
    this.regform.name = this.name;
  //  this.regform.id = this.id;
    this.regform.password = this.password;
   // this.regform.confirmpassword = this.confirmpassword;
    this.regform.contact = this.contact;
    this.regform.dateOfBirth = this.dateOfBirth;
    this.regform.gender = this.gender;
    this.regform.emailId  = this.emailId;
    // this.value = event.target.value;
    console.log(this.dateOfBirth);
    console.log('val: ' + this.password);
    this.regserv.addregister(this.regform).subscribe(data => {

    });
  }

  onChange(event: any) {
    this.gender = event;
    console.log(this.gender);
  }


  constructor(private regserv: UserregistrationService, private http: HttpClient) {

  }

  ngOnInit() {
  }

}
