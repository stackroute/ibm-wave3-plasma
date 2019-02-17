import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { UserRegisterServiceComponent } from './userregisterservice.component';
@NgModule({
  imports: [
    CommonModule,
    FormsModule,
  ],
  declarations: [
    UserRegisterServiceComponent
  ],
  providers: [
   // UserRegisterService

  ]
})
export class UserRegisterServiceModule { }
