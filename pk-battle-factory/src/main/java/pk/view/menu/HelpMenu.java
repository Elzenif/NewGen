package pk.view.menu;

import commons.Constants;
import org.springframework.stereotype.Component;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 * Created by Germain on 01/07/2017.
 */
@Component
public class HelpMenu extends JMenu {

  public HelpMenu() {
    setText(Constants.resourceBundle.getString("menu.help"));
    add(new JMenuItem(Constants.resourceBundle.getString("menu.help.about")));
  }
}
