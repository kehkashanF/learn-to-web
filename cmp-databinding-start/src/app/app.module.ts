import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { CockpiyComponent } from './cockpiy/cockpiy.component';
import { CockpitComponent } from './cockpit/cockpit.component';
import { SeverElementComponent } from './sever-element/sever-element.component';

@NgModule({
  declarations: [
    AppComponent,
    CockpiyComponent,
    CockpitComponent,
    SeverElementComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
