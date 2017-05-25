package commons.view.commons.game;

import commons.controller.intf.Controller;
import commons.model.commons.Game;
import commons.view.ATabbedPanelEmbedded;
import commons.view.GameMainFrame;
import commons.view.HiddenPanel;
import commons.view.dice.DicePanel;

import java.util.ArrayList;
import java.util.List;

import static commons.Constants.resourceBundle;

/**
 * Created by Germain on 24/07/2016.
 */
public abstract class GameTabbedPanelEmbedded extends ATabbedPanelEmbedded<GameMainFrame> {

  protected final List<Controller<GameMainFrame>> controllers = new ArrayList<>();

  protected GameTabbedPanelEmbedded(Game game) {
    HiddenPanel hiddenPanel = new HiddenPanel(game.getName());
    panelMap.put(resourceBundle.getString("panel.hidden"), hiddenPanel);

    DicePanel dicePanel = new DicePanel();
    controllers.add(dicePanel);
    panelMap.put(resourceBundle.getString("panel.dice"), dicePanel);
  }

  @Override
  public void setControllers(GameMainFrame mainFrame) {
    controllers.forEach(controller -> controller.setControllers(mainFrame));
  }
}
