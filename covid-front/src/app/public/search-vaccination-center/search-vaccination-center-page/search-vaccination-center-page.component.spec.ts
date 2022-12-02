import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchVaccinationCenterPageComponent } from './search-vaccination-center-page.component';

describe('SearchVaccinationCenterPageComponent', () => {
  let component: SearchVaccinationCenterPageComponent;
  let fixture: ComponentFixture<SearchVaccinationCenterPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchVaccinationCenterPageComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SearchVaccinationCenterPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
