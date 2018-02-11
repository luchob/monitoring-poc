import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatCardModule } from '@angular/material/card';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatIconModule } from '@angular/material/icon';


@NgModule({
  imports: [
    MatCardModule,
    BrowserAnimationsModule,
    MatExpansionModule,
    MatIconModule
  ],
  exports: [
    MatCardModule,
    BrowserAnimationsModule,
    MatExpansionModule,
    MatIconModule
  ],
  declarations: []
})
export class MaterialModule {
}
