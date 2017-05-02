import { ComponentTestAppPage } from './app.po';

describe('component-test-app App', () => {
  let page: ComponentTestAppPage;

  beforeEach(() => {
    page = new ComponentTestAppPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
