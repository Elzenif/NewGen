package mvc.view.menu;

import mvc.controller.intf.Controller;
import mvc.controller.menu.GameMenuActionListener;
import mvc.model.entity.enums.EGame;
import mvc.view.MainFrame;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Germain on 05/05/2016.
 */
public class MainMenu extends JMenuBar implements Controller {

  private final JMenu gameMenu;
  private final ButtonGroup buttonGroup = new ButtonGroup();
  private final Set<JRadioButtonMenuItem> gameButtons;

  public MainMenu() {
    gameMenu = new JMenu("Game");

    gameButtons = new HashSet<>(EGame.values().length);

    EGame.GAMES.keySet().stream().forEach(eGame -> {
      JRadioButtonMenuItem rb = new JRadioButtonMenuItem(eGame.getName(), eGame.isDefault());
      gameButtons.add(rb);
      buttonGroup.add(rb);
      gameMenu.add(rb);
    });

    add(gameMenu);
  }

  @Override
  public void setControllers(MainFrame view) {
    gameButtons.stream().forEach(rb -> rb.addActionListener(new GameMenuActionListener(view, rb.getText())));
  }
}
