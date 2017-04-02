package commons.view.menu;

import commons.view.GameMainFrame;
import org.jetbrains.annotations.Contract;

/**
 * Created by Germain on 08/10/2016.
 */
public enum EAvailableMenu implements IAvailableMenu<GameMainFrame> {

  GAME_MENU(new GameMenu()),
  HELP_MENU(new HelpMenu());


  private final AMenu<GameMainFrame> menu;

  EAvailableMenu(AMenu<GameMainFrame> menu) {
    this.menu = menu;
  }

  @Override
  public String getName() {
    return menu.getName();
  }

  @Contract(pure = true)
  @Override
  public AMenu<GameMainFrame> getMenu() {
    return menu;
  }
}
