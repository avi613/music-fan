import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { HomePageComponent } from './features/home-page/home.component';
import {ArtistDetailComponent} from './features/artist-detail/artist-detail.component';

@NgModule({
  declarations: [
    HomePageComponent,
    ArtistDetailComponent
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
