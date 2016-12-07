import { Component, Input } from '@angular/core';

import { Artist } from '../artist/artist';

@Component({
  selector: 'artist-fan-page',
  templateUrl: './artist-detail.component.html'
})
export class ArtistFanPageComponent {
  @Input()
  artist: Artist;
}
