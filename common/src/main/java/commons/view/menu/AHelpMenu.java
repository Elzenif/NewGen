package commons.view.menu;

import commons.controller.menu.AboutMenuActionListener;
import commons.view.AMainFrame;

import javax.swing.JMenuItem;

import static commons.Constants.resourceBundle;

/**
 * Created by Germain on 02/04/2017.
 */
public abstract class AHelpMenu<T extends AMainFrame> extends AMenu<T> {

  private final JMenuItem aboutMenuItem;

  public AHelpMenu(String about) {
    super(resourceBundle.getString("menu.help"));

    aboutMenuItem = new JMenuItem(resourceBundle.getString(about));
    add(aboutMenuItem);
  }

  @Override
  public void setControllers(T mainFrame) {
    aboutMenuItem.addActionListener(new AboutMenuActionListener(mainFrame));
  }
}
