package commons.view.menu;

import commons.controller.intf.Controller;
import commons.view.intf.IMainFrame;

import javax.swing.JMenu;

/**
 * Created by Germain on 08/10/2016.
 */
public abstract class AMenu<T extends IMainFrame> extends JMenu implements Controller<T> {

  protected AMenu(String name) {
    super(name);
  }
}
