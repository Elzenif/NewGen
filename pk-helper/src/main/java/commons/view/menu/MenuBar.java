package commons.view.menu;

import commons.view.PkMainFrame;

/**
 * Created by Germain on 02/04/2017.
 */
public class MenuBar extends AMenuBar<PkMainFrame> {

  public MenuBar() {
    super(EAvailableMenu.values());
  }
}
