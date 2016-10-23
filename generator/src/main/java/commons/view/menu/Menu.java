package commons.view.menu;

import commons.controller.intf.Controller;

import javax.swing.JMenu;

/**
 * Created by Germain on 08/10/2016.
 */
public abstract class Menu extends JMenu implements Controller {

  protected Menu(String name) {
    super(name);
  }
}
