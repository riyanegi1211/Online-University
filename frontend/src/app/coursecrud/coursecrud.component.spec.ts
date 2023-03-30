import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CoursecrudComponent } from './coursecrud.component';

describe('CoursecrudComponent', () => {
  let component: CoursecrudComponent;
  let fixture: ComponentFixture<CoursecrudComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CoursecrudComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CoursecrudComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
