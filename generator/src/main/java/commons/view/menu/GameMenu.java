package commons.view.menu;

import commons.controller.menu.GameMenuActionListener;
import commons.utils.CollectionUtils;
import commons.view.MainFrame;
import commons.view.commons.EAvailableGame;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButtonMenuItem;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static commons.view.utils.Constants.resourceBundle;

/**
 * Created by Germain on 08/10/2016.
 */
public class GameMenu extends Menu {

  private final ButtonGroup gameButtonGroup = new ButtonGroup();
  private final Set<JRadioButtonMenuItem> gameButtons;

  public GameMenu() {
    super(resourceBundle.getString("menu.game"));

    gameButtons = CollectionUtils.setMaxSizeSet(new HashSet<>(), EAvailableGame.NB_GAMES);

    Arrays.stream(EAvailableGame.values()).forEach(game -> {
      JRadioButtonMenuItem rb = new JRadioButtonMenuItem(game.getGame().getName(), game.isDefault());
      gameButtons.add(rb);
      gameButtonGroup.add(rb);
      add(rb);
    });

    add(this);
  }

  @Override
  public void setControllers(MainFrame mainFrame) {
    gameButtons.forEach(rb -> rb.addActionListener(new GameMenuActionListener(mainFrame, rb.getText())));
  }
}
