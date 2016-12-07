import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { HomePageComponent } from './features/home-page/home.component';
import { ArtistFanPageComponent } from './features/artist-fan-page/artist-fan-page.component';

@NgModule({
  declarations: [
    HomePageComponent,
    ArtistFanPageComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  providers: [],
  bootstrap: [HomePageComponent]
})
export class AppModule { }
