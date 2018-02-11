import {NgModule} from '@angular/core';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatCardModule} from '@angular/material/card';


@NgModule({
  imports: [
    MatCardModule,
    BrowserAnimationsModule
  ],
  exports: [
    MatCardModule,
    BrowserAnimationsModule
  ],
  declarations: []
})
export class MaterialModule {
}
