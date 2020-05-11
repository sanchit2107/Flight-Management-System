import { TestBed } from '@angular/core/testing';

import { ScheduledFlightService } from './scheduled-flight.service';

describe('ScheduledFlightService', () => {
  let service: ScheduledFlightService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ScheduledFlightService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
