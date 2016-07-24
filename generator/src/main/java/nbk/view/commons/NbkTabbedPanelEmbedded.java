package nbk.view.commons;

import commons.view.commons.GameTabbedPanelEmbedded;
import commons.view.dice.DicePanel;
import commons.view.entity.EntityPanel;
import commons.view.hidden.HiddenPanel;
import nbk.model.commons.NbkGame;
import nbk.view.entity.items.NbkEntityPanel;

/**
 * Created by Germain on 24/07/2016.
 */
public class NbkTabbedPanelEmbedded extends GameTabbedPanelEmbedded<NbkGame> {

  private final HiddenPanel<NbkGame> hiddenPanel;
  private final DicePanel dicePanel;
  private final EntityPanel entityPanel;

  public NbkTabbedPanelEmbedded() {
    hiddenPanel = new HiddenPanel<>(NbkGame.getInstance());
    panelMap.put("Hidden", hiddenPanel);
    
    dicePanel = new DicePanel();
    controllers.add(dicePanel);
    panelMap.put("Dice", dicePanel);

    entityPanel = new NbkEntityPanel();
    controllers.add(entityPanel);
    panelMap.put("Entity", entityPanel);

    addPanels();
  }
}
