import { Component } from '@angular/core';

@Component({
  selector: 'music-fan-app',
  template: `
  <h1>
    {{title}}
  </h1>
  <a routerLink="all-artists">View All Artists</a>
  <router-outlet></router-outlet>
  `
})
export class AppComponent {
  title = 'Music Fan!'
}
