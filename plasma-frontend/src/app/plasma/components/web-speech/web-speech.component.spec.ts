import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WebSpeechComponent } from './web-speech.component';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { SpeechRecognizerService } from '../../services/speech-recognizer.service';
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
