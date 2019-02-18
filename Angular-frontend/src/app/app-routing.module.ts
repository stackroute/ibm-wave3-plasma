import { WebSpeechComponent } from './plasma/web-speech/web-speech.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserRegisterServiceComponent } from './plasma/userregister/userregisterservice.component';


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
    path: 'userregister',
    component: UserRegisterServiceComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
