import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { HomePageComponent } from './features/home/home.component'
import { AllArtistsComponent } from './features/all-artists/all-artists.component';
import { ArtistFanPageComponent } from './features/artist-fan-page/artist-fan-page.component';

@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    AllArtistsComponent,
    ArtistFanPageComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot([
      {
        path: 'home',
        component: HomePageComponent
      },
      {
        path: '',
        redirectTo: '/home',
        pathMatch: 'full'
      },
      {
        path: 'all-artists',
        component: AllArtistsComponent
      },
      {
        path: 'artist-page/:id',
        component: ArtistFanPageComponent
      }
    ]),
    HttpModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
