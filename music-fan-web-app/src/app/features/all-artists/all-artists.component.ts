import { Component } from '@angular/core'
import { OnInit } from '@angular/core'
import { Router } from '@angular/router'

import { Artist } from '../artist/artist'
import { ArtistService } from '../artist/service/artist.service'

@Component({
  selector: 'music-fan-home',
  templateUrl: './all-artists.component.html',
  styleUrls: ['./all-artists.component.css']
})
export class AllArtistsComponent implements OnInit {
  artists: Artist[]
  selectedArtist: Artist

  constructor(
    private router: Router,
    private artistService: ArtistService) { }

  ngOnInit(): void { this.getArtists() }

  getArtists(): void {
    this.artistService.getArtists()
      .then(artists => this.artists = artists)
  }

  onSelect(artist: Artist): void {
    this.selectedArtist = artist
  }

  goToFanPage(): void {
    this.router.navigate(['/artist-page', this.selectedArtist.id])
  }
}
