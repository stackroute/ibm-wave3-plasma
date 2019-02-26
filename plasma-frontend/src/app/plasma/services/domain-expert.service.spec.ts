import { TestBed } from '@angular/core/testing';

import { DomainExpertService } from './domain-expert.service';

describe('DomainExpertService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: DomainExpertService = TestBed.get(DomainExpertService);
    expect(service).toBeTruthy();
  });
});
