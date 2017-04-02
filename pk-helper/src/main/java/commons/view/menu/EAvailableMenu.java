package commons.view.menu;

import org.jetbrains.annotations.Contract;
import commons.view.PkMainFrame;

/**
 * Created by Germain on 02/04/2017.
 */
public enum EAvailableMenu implements IAvailableMenu<PkMainFrame> {

  HELP_MENU(new HelpMenu());


  private final AMenu<PkMainFrame> menu;

  EAvailableMenu(AHelpMenu<PkMainFrame> menu) {
    this.menu = menu;
  }

  @Override
  public String getName() {
    return menu.getName();
  }

  @Contract(pure = true)
  @Override
  public AMenu<PkMainFrame> getMenu() {
    return menu;
  }
}
