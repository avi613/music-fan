import { Component, OnInit } from '@angular/core'

import { Artist } from '../artist/artist'
import { ArtistService } from '../artist/service/artist.service'

@Component({
  selector: 'home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  providers: [ArtistService]
})
export class HomePageComponent implements OnInit {
  artists: Artist[] = []

  constructor(private artistService: ArtistService) { }

  ngOnInit(): void {
    this.artistService.getArtists()
      .then(artists => this.artists = artists.slice(1, 5))
  }
}
