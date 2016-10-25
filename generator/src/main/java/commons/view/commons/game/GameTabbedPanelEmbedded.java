package commons.view.commons.game;

import commons.controller.intf.Controller;
import commons.model.commons.Game;
import commons.view.MainFrame;
import commons.view.dice.DicePanel;
import commons.view.hidden.HiddenPanel;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static commons.view.utils.Constants.resourceBundle;

/**
 * Created by Germain on 24/07/2016.
 */
public abstract class GameTabbedPanelEmbedded<G extends Game> extends JTabbedPane implements Controller {

  protected final Map<String, JPanel> panelMap = new LinkedHashMap<>();

  protected final List<Controller> controllers = new ArrayList<>();

  private final HiddenPanel<G> hiddenPanel;
  private final DicePanel dicePanel;

  protected GameTabbedPanelEmbedded(G game) {
    super(SwingConstants.TOP);

    hiddenPanel = new HiddenPanel<>(game);
    panelMap.put(resourceBundle.getString("panel.hidden"), hiddenPanel);

    dicePanel = new DicePanel();
    controllers.add(dicePanel);
    panelMap.put(resourceBundle.getString("panel.dice"), dicePanel);
  }

  @Override
  public void setControllers(MainFrame mainFrame) {
    controllers.forEach(controller -> controller.setControllers(mainFrame));
  }

  protected void addPanels() {
    panelMap.forEach(this::addTab);
  }
}
