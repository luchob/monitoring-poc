import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable()
export class QuotesServiceService {

  randomQuoteUrl = 'api/random-quote';

  constructor(private http: HttpClient) { }

  getRandomQuote() {
    return this.http.get(this.randomQuoteUrl);
  }
}
