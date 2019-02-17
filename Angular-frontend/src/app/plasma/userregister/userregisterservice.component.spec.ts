import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserRegisterServiceComponent } from './userregisterservice.component';

describe('UserRegisterServiceComponent', () => {
  let component: UserRegisterServiceComponent;
  let fixture: ComponentFixture<UserRegisterServiceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserRegisterServiceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserRegisterServiceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
