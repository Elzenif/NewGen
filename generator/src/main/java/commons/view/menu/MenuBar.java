package commons.view.menu;

import commons.view.GameMainFrame;

/**
 * Created by Germain on 05/05/2016.
 */
public class MenuBar extends AMenuBar<GameMainFrame> {

  public MenuBar() {
    super(EAvailableMenu.values());
  }
}
