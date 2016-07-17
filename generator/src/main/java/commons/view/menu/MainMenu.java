package commons.view.menu;

import commons.controller.intf.Controller;
import commons.controller.menu.GameMenuActionListener;
import commons.view.MainFrame;
import commons.view.entity.EGame;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static commons.utils.CollectionUtils.setMaxSize;

/**
 * Created by Germain on 05/05/2016.
 */
public class MainMenu extends JMenuBar implements Controller {

  private final JMenu gameMenu;
  private final ButtonGroup buttonGroup = new ButtonGroup();
  private final List<JRadioButtonMenuItem> gameButtons;

  public MainMenu() {
    gameMenu = new JMenu("Game");

    gameButtons = setMaxSize(new ArrayList<>(), EGame.NB_GAMES);

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
