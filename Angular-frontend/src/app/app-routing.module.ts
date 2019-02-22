import { UserLoginComponent } from './plasma/components/user-login/user-login.component';
import { HeaderComponent } from './plasma/components/header/header.component';
import { WebSpeechComponent } from './plasma/components/web-speech/web-speech.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DomainExpertComponent } from './plasma/components/domain-expert/domain-expert.component';
import { UserregistrationComponent } from './plasma/components/userregistration/userregistration.component';

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
    path: 'admin',
    component: DomainExpertComponent
  },
  {
    path: 'header',
    component: HeaderComponent
  },
  {
   path: 'userregistration',
    component: UserregistrationComponent
  },
  {
    path: 'login',
    component: UserLoginComponent
  }

];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
