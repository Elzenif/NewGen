package pk.view.menu;

import commons.view.menu.AHelpMenu;
import commons.view.menu.AMenu;
import commons.view.menu.IAvailableMenu;
import org.jetbrains.annotations.Contract;
import pk.view.MainFrame;

/**
 * Created by Germain on 02/04/2017.
 */
public enum EAvailableMenu implements IAvailableMenu<MainFrame> {

  HELP_MENU(new HelpMenu());


  private final AMenu<MainFrame> menu;

  EAvailableMenu(AHelpMenu<MainFrame> menu) {
    this.menu = menu;
  }

  @Override
  public String getName() {
    return menu.getName();
  }

  @Contract(pure = true)
  @Override
  public AMenu<MainFrame> getMenu() {
    return menu;
  }
}
