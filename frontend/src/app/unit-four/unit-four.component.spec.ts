import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UnitFourComponent } from './unit-four.component';

describe('UnitFourComponent', () => {
  let component: UnitFourComponent;
  let fixture: ComponentFixture<UnitFourComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UnitFourComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UnitFourComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
