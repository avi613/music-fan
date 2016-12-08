import { Component, Input, OnInit } from '@angular/core'
import { ActivatedRoute, Params } from '@angular/router'
import { Location } from '@angular/common'

import 'rxjs/add/operator/switchMap'

import { Artist } from '../artist/artist'
import { ArtistService } from '../artist/service/artist.service'

@Component({
  selector: 'artist-fan-page',
  templateUrl: './artist-fan-page.component.html',
  providers: [ArtistService]
})
export class ArtistFanPageComponent implements OnInit {
  @Input()
  artist: Artist

  constructor(
    private artistService: ArtistService,
    private route: ActivatedRoute,
    private location: Location
  ) { }

  ngOnInit(): void {
    this.route.params
      .switchMap((params: Params) => this.artistService.getArtist(+params['id']))
      .subscribe(artist => this.artist = artist)
  }

  goBack(): void {
    this.location.back()
  }
}
