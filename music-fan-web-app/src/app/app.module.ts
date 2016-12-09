import { NgModule } from '@angular/core'
import { BrowserModule } from '@angular/platform-browser'
import { FormsModule } from '@angular/forms'

import { HttpModule } from '@angular/http'

import { AppComponent } from './app.component'
import { HomePageComponent } from './features/home/home.component'
import { AllArtistsComponent } from './features/all-artists/all-artists.component'
import { ArtistFanPageComponent } from './features/artist-fan-page/artist-fan-page.component'

import { ArtistService } from './features/artist/service/artist.service'

import { AppRoutingModule } from './app-routing.module'

@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpModule
  ],
  declarations: [
    AppComponent,
    HomePageComponent,
    AllArtistsComponent,
    ArtistFanPageComponent
  ],
  providers: [ArtistService],
  bootstrap: [AppComponent]
})
export class AppModule { }
