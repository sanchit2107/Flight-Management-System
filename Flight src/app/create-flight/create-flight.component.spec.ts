import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateFlightComponent } from './create-flight.component';

describe('CreateFlightComponent', () => {
  let component: CreateFlightComponent;
  let fixture: ComponentFixture<CreateFlightComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateFlightComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateFlightComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
