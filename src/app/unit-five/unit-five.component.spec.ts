import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UnitFiveComponent } from './unit-five.component';

describe('UnitFiveComponent', () => {
  let component: UnitFiveComponent;
  let fixture: ComponentFixture<UnitFiveComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UnitFiveComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UnitFiveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
