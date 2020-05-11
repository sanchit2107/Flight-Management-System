import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddScheduledFlightComponent } from './add-scheduled-flight.component';

describe('AddScheduledFlightComponent', () => {
  let component: AddScheduledFlightComponent;
  let fixture: ComponentFixture<AddScheduledFlightComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddScheduledFlightComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddScheduledFlightComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
