import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserpanelComponent } from './userpanel.component';

describe('UserpanelComponent', () => {
  let component: UserpanelComponent;
  let fixture: ComponentFixture<UserpanelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserpanelComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserpanelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
