import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WebSpeechComponent } from './web-speech.component';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
<<<<<<< HEAD:Angular-frontend/src/app/plasma/components/web-speech/web-speech.component.spec.ts
import { SpeechRecognizerService } from '../../services/speech-recognizer.service';




=======
import { SpeechRecognizerService } from '../services/speech-recognizer.service';
>>>>>>> de218c87c211cd16f28e0afb5af9003fdb59cd3b:Angular-frontend/src/app/plasma/web-speech/web-speech.component.spec.ts
describe('WebSpeechComponent', () => {
  let component: WebSpeechComponent;
  let fixture: ComponentFixture<WebSpeechComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        WebSpeechComponent
      ],
      schemas: [
        CUSTOM_ELEMENTS_SCHEMA
      ],
      providers: [
        SpeechRecognizerService

      ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WebSpeechComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
