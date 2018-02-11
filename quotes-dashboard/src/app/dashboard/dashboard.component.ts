import {Component, OnInit, ViewChild} from '@angular/core';
import {QuoteDetailComponent} from "../quote-detail/quote-detail.component";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  @ViewChild(QuoteDetailComponent)
  private quoteDetailComponent: QuoteDetailComponent;


  constructor() { }

  ngOnInit() {
    this.quoteDetailComponent.quoteText = 'Real magic in relationships means an absence of judgement of others.';
    this.quoteDetailComponent.quoteAuthor = 'Wayne Dyer';
  }

}
