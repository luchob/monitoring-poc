import { TestBed, inject } from '@angular/core/testing';

import { QuotesServiceService } from './quotes-service.service';

describe('QuotesServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [QuotesServiceService]
    });
  });

  it('should be created', inject([QuotesServiceService], (service: QuotesServiceService) => {
    expect(service).toBeTruthy();
  }));
});
