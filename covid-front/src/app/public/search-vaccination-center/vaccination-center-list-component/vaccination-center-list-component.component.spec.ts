import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VaccinationCenterListComponentComponent } from './vaccination-center-list-component.component';

describe('VaccinationCenterListComponentComponent', () => {
  let component: VaccinationCenterListComponentComponent;
  let fixture: ComponentFixture<VaccinationCenterListComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VaccinationCenterListComponentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VaccinationCenterListComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
