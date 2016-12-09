import { NgModule } from '@angular/core'
import { RouterModule, Routes } from '@angular/router'

import { HomePageComponent } from './features/home/home.component'
import { ArtistFanPageComponent } from './features/artist-fan-page/artist-fan-page.component'
import { AllArtistsComponent } from './features/all-artists/all-artists.component'

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: HomePageComponent },
  { path: 'all-artists', component: AllArtistsComponent },
  { path: 'artist-page/:id', component: ArtistFanPageComponent }
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
