package pk.view.menu;

import commons.view.menu.AMenuBar;
import pk.view.MainFrame;

/**
 * Created by Germain on 02/04/2017.
 */
public class MenuBar extends AMenuBar<MainFrame> {

  public MenuBar() {
    super(EAvailableMenu.values());
  }
}
