package commons.view.menu;

import commons.view.MainFrame;

/**
 * Created by Germain on 08/10/2016.
 */
public enum EAvailableMenu implements IAvailableMenu<MainFrame> {

  GAME_MENU(new GameMenu()),
  HELP_MENU(new HelpMenu());


  private final AMenu<MainFrame> menu;

  EAvailableMenu(AMenu<MainFrame> menu) {
    this.menu = menu;
  }

  @Override
  public String getName() {
    return menu.getName();
  }

  @Override
  public AMenu<MainFrame> getMenu() {
    return menu;
  }
}
