import { MusicFanWebAppPage } from './app.po';

describe('music-fan-web-app App', function() {
  let page: MusicFanWebAppPage;

  beforeEach(() => {
    page = new MusicFanWebAppPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
