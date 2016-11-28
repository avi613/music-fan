import { Component } from '@angular/core';

@Component({
  selector: 'music-fan-app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Music Fan';
  artist: Artist = {
    id: 1,
    fullName: 'Georges Brassens'
  };
  artists = ARTISTS;
  selectedArtist: Artist;

  onSelect(artist: Artist): void {
    this.selectedArtist = artist;
  }
}

export class Artist {
  id: number;
  fullName: string;
}

const ARTISTS: Artist[] = [
  { id: 1, fullName: 'Georges Brassens' },
  { id: 2, fullName: 'Edith Piaf' },
  { id: 3, fullName: 'Robert Fripp' },
  { id: 4, fullName: 'Michael Jackson' },
  { id: 5, fullName: 'Leroi Moore' },
  { id: 6, fullName: 'David Gilmour' },
  { id: 7, fullName: 'Herbie Hancock' },
  { id: 8, fullName: 'Tim Reynolds' },
  { id: 9, fullName: 'Tito Puente' },
  { id: 10, fullName: 'Vinnie Colaiuta' }
]
