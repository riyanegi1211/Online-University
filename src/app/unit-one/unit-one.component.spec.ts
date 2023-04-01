import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UnitOneComponent } from './unit-one.component';

describe('UnitOneComponent', () => {
  let component: UnitOneComponent;
  let fixture: ComponentFixture<UnitOneComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UnitOneComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UnitOneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
