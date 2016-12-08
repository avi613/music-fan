import { Component } from '@angular/core';
import { OnInit } from '@angular/core';

import { Artist } from '../artist/artist';
import { ArtistService } from '../artist/service/artist.service';

@Component({
  selector: 'music-fan-home',
  templateUrl: './all-artists.component.html',
  styleUrls: ['./all-artists.component.css'],
  providers: [ArtistService]
})
export class AllArtistsComponent implements OnInit {
  title = 'Music Fan';
  artists: Artist[];
  selectedArtist: Artist;

  constructor(private artistService: ArtistService) { }

  ngOnInit(): void { this.getArtists() }

  getArtists(): void {
    this.artistService.getArtists()
      .then(artists => this.artists = artists);
  }

  onSelect(artist: Artist): void {
    this.selectedArtist = artist;
  }
}
