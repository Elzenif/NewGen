package pk.view.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.JMenuBar;

/**
 * Created by Germain on 01/07/2017.
 */
@Component
public class MenuBar extends JMenuBar {

  @Autowired
  public MenuBar(OptionMenu optionMenu, HelpMenu helpMenu) {
    add(optionMenu);
    add(helpMenu);
  }
}
