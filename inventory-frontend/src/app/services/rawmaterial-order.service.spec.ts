import { TestBed } from '@angular/core/testing';

import { RawmaterialOrderService } from './rawmaterial-order.service';

describe('RawmaterialOrderService', () => {
  let service: RawmaterialOrderService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RawmaterialOrderService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
