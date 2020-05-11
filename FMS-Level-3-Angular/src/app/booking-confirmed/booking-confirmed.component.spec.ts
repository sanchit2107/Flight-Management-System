import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BookingConfirmedComponent } from './booking-confirmed.component';

describe('BookingConfirmedComponent', () => {
  let component: BookingConfirmedComponent;
  let fixture: ComponentFixture<BookingConfirmedComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BookingConfirmedComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BookingConfirmedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
