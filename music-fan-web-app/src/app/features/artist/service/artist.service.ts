import { Injectable } from '@angular/core';

import { Artist } from '../artist';
import { ARTISTS } from './mock-artists';

@Injectable()
export class ArtistService {
  getArtists(): Promise<Artist[]> {
    return Promise.resolve(ARTISTS);
  }

  getArtist(id: number): Promise<Artist> {
    return this.getArtists()
      .then(artists => artists.find(artist => artist.id === id))
  }
}
