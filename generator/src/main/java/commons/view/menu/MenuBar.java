package commons.view.menu;

import commons.controller.intf.Controller;
import commons.view.MainFrame;

import javax.swing.JMenuBar;
import java.util.Arrays;

/**
 * Created by Germain on 05/05/2016.
 */
public class MenuBar extends JMenuBar implements Controller {

  public MenuBar() {
    Arrays.stream(EAvailableMenu.values()).forEach(availableMenu -> add(availableMenu.getMenu()));
  }

  @Override
  public void setControllers(MainFrame mainFrame) {
    Arrays.stream(EAvailableMenu.values()).forEach(availableMenu -> availableMenu.getMenu().setControllers(mainFrame));
  }
}
