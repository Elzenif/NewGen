package commons.view.menu;

import commons.controller.intf.Controller;
import commons.controller.menu.GameMenuActionListener;
import commons.utils.CollectionUtils;
import commons.view.MainFrame;
import commons.view.commons.EGame;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;
import java.util.Arrays;
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

    gameButtons = CollectionUtils.setMaxSizeSet(new HashSet<>(), EGame.NB_GAMES);

    Arrays.stream(EGame.values()).forEach(eGame -> {
      JRadioButtonMenuItem rb = new JRadioButtonMenuItem(eGame.getGame().getName(), eGame.isDefault());
      gameButtons.add(rb);
      buttonGroup.add(rb);
      gameMenu.add(rb);
    });

    add(gameMenu);
  }

  @Override
  public void setControllers(MainFrame view) {
    gameButtons.forEach(rb -> rb.addActionListener(new GameMenuActionListener(view, rb.getText())));
  }
}
