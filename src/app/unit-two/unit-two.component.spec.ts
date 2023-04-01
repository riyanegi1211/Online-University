import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UnitTwoComponent } from './unit-two.component';

describe('UnitTwoComponent', () => {
  let component: UnitTwoComponent;
  let fixture: ComponentFixture<UnitTwoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UnitTwoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UnitTwoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
