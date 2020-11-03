import { TestBed } from '@angular/core/testing';

import { RawmaterialService } from './rawmaterial.service';

describe('RawmaterialService', () => {
  let service: RawmaterialService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RawmaterialService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
