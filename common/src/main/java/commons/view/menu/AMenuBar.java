package commons.view.menu;

import commons.controller.intf.Controller;
import commons.view.intf.IMainFrame;

import javax.swing.JMenuBar;
import java.util.Arrays;

/**
 * Created by Germain on 31/03/2017.
 */
public abstract class AMenuBar<T extends IMainFrame> extends JMenuBar implements Controller<T> {

  private final IAvailableMenu<T>[] availableMenus;

  public AMenuBar(IAvailableMenu<T>[] availableMenus) {
    this.availableMenus = availableMenus;
    Arrays.stream(availableMenus).forEach(availableMenu -> add(availableMenu.getMenu()));
  }

  public void setControllers(T mainFrame) {
    Arrays.stream(availableMenus).forEach(availableMenu -> availableMenu.getMenu().setControllers(mainFrame));
  }
}
