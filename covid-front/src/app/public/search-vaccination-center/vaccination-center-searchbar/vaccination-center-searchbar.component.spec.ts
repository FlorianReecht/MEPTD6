import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VaccinationCenterSearchbarComponent } from './vaccination-center-searchbar.component';

describe('VaccinationCenterSearchbarComponent', () => {
  let component: VaccinationCenterSearchbarComponent;
  let fixture: ComponentFixture<VaccinationCenterSearchbarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VaccinationCenterSearchbarComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VaccinationCenterSearchbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
