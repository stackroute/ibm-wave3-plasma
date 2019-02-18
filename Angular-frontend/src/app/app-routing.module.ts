import { WebSpeechComponent } from './plasma/components/web-speech/web-speech.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserRegisterComponent } from './plasma/user-register/user-register.component';
import { DomainExpertComponent } from './plasma/components/domain-expert/domain-expert.component';


const routes: Routes = [
  {
    path: '',
    redirectTo: 'web-speech',
    pathMatch: 'full'
  },
  {
    path: 'web-speech',
    component: WebSpeechComponent
  },
  {
    path: 'signup',
    component: UserRegisterComponent
  },
  {
    path: 'admin',
    component: DomainExpertComponent
  }
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
