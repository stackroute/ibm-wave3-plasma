import { Observable, observable } from 'rxjs';
import { Component } from '@angular/core';
import { SearchService } from './web-speech/shared/services/search.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'wsa-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
//   subscribe: any;
// constructor (private svc: SearchService, private http: HttpClient) {
//   this.svc.console.log('go to service');

// }
// // tslint:disable-next-line:use-life-cycle-interface
// ngOnInit() {
//   // tslint:disable-next-line:no-shadowed-variable
//   // const observable = this.http.get('https://github.com/saidurgakoduri');
//   // observable.subscribe((response) => console.log(response));
// }

// }
}
