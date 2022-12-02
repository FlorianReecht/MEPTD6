import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VaccinationCenterComponentComponent } from './vaccination-center-component.component';

describe('VaccinationCenterComponentComponent', () => {
  let component: VaccinationCenterComponentComponent;
  let fixture: ComponentFixture<VaccinationCenterComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VaccinationCenterComponentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VaccinationCenterComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
