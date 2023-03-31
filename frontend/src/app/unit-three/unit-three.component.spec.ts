import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UnitThreeComponent } from './unit-three.component';

describe('UnitThreeComponent', () => {
  let component: UnitThreeComponent;
  let fixture: ComponentFixture<UnitThreeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UnitThreeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UnitThreeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
