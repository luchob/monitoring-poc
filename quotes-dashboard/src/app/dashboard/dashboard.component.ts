import { Component, OnInit, ViewChild } from '@angular/core';
import { QuoteDetailComponent } from '../quote-detail/quote-detail.component';
import {QuotesServiceService} from '../quotes-service/quotes-service.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  @ViewChild(QuoteDetailComponent)
  private quoteDetailComponent: QuoteDetailComponent;


  constructor(private quoteService: QuotesServiceService) { }

  ngOnInit() {
    this.refreshQuote();
  }

  private refreshQuote() {
    this.quoteService.getRandomQuote().subscribe(data => {

      this.quoteDetailComponent.quoteText = data['text'];
      this.quoteDetailComponent.quoteAuthor = data['author'];
    }
    );
  }

  onRefresh() {
    this.refreshQuote();
  }

}
