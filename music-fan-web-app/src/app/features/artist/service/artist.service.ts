import { Injectable } from '@angular/core'
import { Headers, Http } from '@angular/http'

import 'rxjs/add/operator/toPromise'

import { Artist } from '../artist'

@Injectable()
export class ArtistService {
  private artistsUrl = 'api/artists'
  private headers = new Headers({'Content-Type': 'application/json'})

  constructor(private http: Http) { }

  getArtists(): Promise<Artist[]> {
    return this.http.get(this.artistsUrl)
      .toPromise()
      .then(response => response.json().data as Artist[])
      .catch(this.handleError)
  }

  getArtist(id: number): Promise<Artist> {
    return this.http.get(`${this.artistsUrl}/${id}`)
      .toPromise()
      .then(response => response.json().data as Artist)
      .catch(this.handleError)
  }

  create(name: string, path: string): Promise<Artist> {
    return this.http
      .post(this.artistsUrl, JSON.stringify({fullName: name, mainPicturePath: path}), {headers: this.headers})
      .toPromise()
      .then(response => response.json().data)
      .catch(this.handleError)
  }

  private handleError(error: any): Promise<any> {
    console.log('ERROR', error)
    return Promise.reject(error.message || error)
  }
}
