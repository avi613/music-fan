import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { HomePageComponent } from './features/all-artists/home.component';
import { ArtistFanPageComponent } from './features/artist-fan-page/artist-fan-page.component';

@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    ArtistFanPageComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot([
      {
        path: 'all-artists',
        component: HomePageComponent
      }
    ]),
    HttpModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
