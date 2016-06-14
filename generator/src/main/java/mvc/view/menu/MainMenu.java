package mvc.view.menu;

import mvc.controller.intf.Controller;
import mvc.controller.menu.GameMenuActionListener;
import mvc.view.entity.EGame;
import mvc.view.MainFrame;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static utils.CollectionUtils.setMaxSize;

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

    Arrays.asList(EGame.values()).stream().forEach(eGame -> {
      JRadioButtonMenuItem rb = new JRadioButtonMenuItem(eGame.getGame().getName(), eGame.isDefault());
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
