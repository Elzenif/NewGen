package commons.view.menu;

/**
 * Created by Germain on 08/10/2016.
 */
public enum EAvailableMenu implements IAvailableMenu {

  GAME_MENU(new GameMenu()),
  HELP_MENU(new HelpMenu());


  private final Menu menu;

  EAvailableMenu(Menu menu) {
    this.menu = menu;
  }

  @Override
  public String getName() {
    return menu.getName();
  }

  @Override
  public Menu getMenu() {
    return menu;
  }
}
