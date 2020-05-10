import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowScheduledFlightsComponent } from './show-scheduled-flights.component';

describe('ShowScheduledFlightsComponent', () => {
  let component: ShowScheduledFlightsComponent;
  let fixture: ComponentFixture<ShowScheduledFlightsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowScheduledFlightsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowScheduledFlightsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
