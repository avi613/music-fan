import { Component, Input } from '@angular/core';

import { Artist } from '../artist/artist';

@Component({
  selector: 'artist-detail',
  templateUrl: './artist-detail.component.html'
})
export class ArtistDetailComponent {
  @Input()
  artist: Artist;
}
