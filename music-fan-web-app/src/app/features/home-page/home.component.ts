import { Component } from '@angular/core';

import { Artist } from '../artist/artist'

@Component({
  selector: 'music-fan-app-root',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomePageComponent {
  title = 'Music Fan';
  artist: Artist = {
    id: 1,
    fullName: 'Georges Brassens',
    mainPicturePath: ''
  };
  artists = ARTISTS;
  selectedArtist: Artist;

  onSelect(artist: Artist): void {
    this.selectedArtist = artist;
  }
}

const ARTISTS: Artist[] = [
  { id: 1, fullName: 'Georges Brassens', mainPicturePath: 'assets\\artists\\photos\\jimi-hendrix.jpg' },
  { id: 2, fullName: 'Edith Piaf', mainPicturePath: 'assets\\artists\\photos\\jimi-hendrix.jpg' },
  { id: 3, fullName: 'Robert Fripp', mainPicturePath: 'assets\\artists\\photos\\jimi-hendrix.jpg' },
  { id: 4, fullName: 'Jimi Hendrix', mainPicturePath: 'assets\\artists\\photos\\jimi-hendrix.jpg' },
  { id: 5, fullName: 'Leroi Moore', mainPicturePath: 'assets\\artists\\photos\\jimi-hendrix.jpg' },
  { id: 6, fullName: 'David Gilmour', mainPicturePath: 'assets\\artists\\photos\\jimi-hendrix.jpg' },
  { id: 7, fullName: 'Herbie Hancock', mainPicturePath: 'assets\\artists\\photos\\jimi-hendrix.jpg' },
  { id: 8, fullName: 'Tim Reynolds', mainPicturePath: 'assets\\artists\\photos\\jimi-hendrix.jpg' },
  { id: 9, fullName: 'Tito Puente', mainPicturePath: 'assets\\artists\\photos\\jimi-hendrix.jpg' },
  { id: 10, fullName: 'Vinnie Colaiuta', mainPicturePath: 'assets\\artists\\photos\\jimi-hendrix.jpg' }
]
