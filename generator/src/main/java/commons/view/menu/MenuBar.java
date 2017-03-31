package commons.view.menu;

import commons.view.MainFrame;

/**
 * Created by Germain on 05/05/2016.
 */
public class MenuBar extends AMenuBar<MainFrame> {

  public MenuBar() {
    super(EAvailableMenu.values());
  }
}
