import { WebSpeechComponent } from './plasma/components/web-speech/web-speech.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DomainExpertComponent } from './plasma/components/domain-expert/domain-expert.component';
import { UserregistrationComponent } from './plasma/components/userregistration/userregistration.component';
// import { DomainExpertComponent } from './plasma/components/domain-expert/domain-expert.component';
// import { UserRegisterComponent } from './plasma/components/user-register/user-register.component';


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
    path: 'domain-expert',
    component: DomainExpertComponent
  },
  {
    path: 'userregistration',
    component: UserregistrationComponent
  },
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
