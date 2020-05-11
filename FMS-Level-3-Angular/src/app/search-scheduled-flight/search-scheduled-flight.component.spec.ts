import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchScheduledFlightComponent } from './search-scheduled-flight.component';

describe('SearchScheduledFlightComponent', () => {
  let component: SearchScheduledFlightComponent;
  let fixture: ComponentFixture<SearchScheduledFlightComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SearchScheduledFlightComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchScheduledFlightComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
