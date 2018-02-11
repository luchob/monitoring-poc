import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { MaterialModule} from './material/material.module';
import { AppComponent } from './app.component';
import { QuoteDetailComponent } from './quote-detail/quote-detail.component';
import { HttpClientModule } from '@angular/common/http';
import { DashboardComponent } from './dashboard/dashboard.component';



@NgModule({
  declarations: [
    AppComponent,
    QuoteDetailComponent,
    DashboardComponent
  ],
  imports: [
    BrowserModule,
    MaterialModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
