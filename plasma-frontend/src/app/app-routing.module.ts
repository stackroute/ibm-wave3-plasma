import { AboutComponent } from './plasma/components/about/about.component';
import { CardComponent } from './plasma/components/card/card.component';
import { UserLoginComponent } from './plasma/components/user-login/user-login.component';
import { HeaderComponent } from './plasma/components/header/header.component';
import { WebSpeechComponent } from './plasma/components/web-speech/web-speech.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DomainExpertComponent } from './plasma/components/domain-expert/domain-expert.component';
import { UserregistrationComponent } from './plasma/components/userregistration/userregistration.component';
import { ProfileComponent } from './plasma/components/profile/profile.component';
import { AuthGuard } from './plasma/components/auth/auth.guard';


const routes: Routes = [
  {
    path: '',
    redirectTo: 'web-speech',
    pathMatch: 'full'
  },
  {
    path: 'web-speech',
    component: WebSpeechComponent,
  },
  {
    path: 'admin',
    component: DomainExpertComponent,
     canActivate: [AuthGuard]
  },
  {
    path: 'header',
    component: HeaderComponent
  },
  {
   path: 'signup',
    component: UserregistrationComponent
  },
  {
    path: 'login',
    component: UserLoginComponent
  },
  {
    path: 'card',
    component: CardComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'profile',
    component: ProfileComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'about',
    component: AboutComponent
    }

];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
