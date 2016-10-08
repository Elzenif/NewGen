package commons.view.menu;

import commons.controller.intf.Controller;
import commons.view.MainFrame;

import javax.swing.JMenuBar;
import java.util.Arrays;

/**
 * Created by Germain on 05/05/2016.
 */
public class MainMenu extends JMenuBar implements Controller {

  public MainMenu() {
    Arrays.stream(EAvailableMenu.values()).forEach(availableMenu -> this.add(availableMenu.getMenu()));
  }

  @Override
  public void setControllers(MainFrame view) {
    Arrays.stream(EAvailableMenu.values()).forEach(availableMenu -> availableMenu.getMenu().setControllers(view));
  }
}
