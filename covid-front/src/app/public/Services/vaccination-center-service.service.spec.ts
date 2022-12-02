import { TestBed } from '@angular/core/testing';

import { VaccinationCenterServiceService } from './vaccination-center-service.service';

describe('VaccinationCenterServiceService', () => {
  let service: VaccinationCenterServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VaccinationCenterServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
