package commons.view.menu;

import commons.controller.menu.AboutMenuActionListener;
import commons.view.MainFrame;

import javax.swing.JMenuItem;

import static commons.Constants.resourceBundle;

/**
 * Created by Germain on 08/10/2016.
 */
public class HelpMenu extends AMenu<MainFrame> {

  private final JMenuItem aboutMenuItem;

  public HelpMenu() {
    super(resourceBundle.getString("menu.help"));

    aboutMenuItem = new JMenuItem(resourceBundle.getString("menu.help.about"));
    add(aboutMenuItem);
  }

  @Override
  public void setControllers(MainFrame mainFrame) {
    aboutMenuItem.addActionListener(new AboutMenuActionListener(mainFrame));
  }
}
