package nbk.view.commons;

import commons.view.commons.GameTabbedPanelEmbedded;
import commons.view.dice.DicePanel;
import commons.view.entity.EntityPanelEmbedded;
import commons.view.hidden.HiddenPanelEmbedded;
import nbk.model.commons.NbkGame;
import nbk.view.entity.items.NbkEntityPanelEmbedded;

/**
 * Created by Germain on 24/07/2016.
 */
public class NbkTabbedPanelEmbedded extends GameTabbedPanelEmbedded<NbkGame> {

  private final HiddenPanelEmbedded<NbkGame> hiddenPanel;
  private final DicePanel dicePanel;
  private final EntityPanelEmbedded entityPanel;

  public NbkTabbedPanelEmbedded() {
    hiddenPanel = new HiddenPanelEmbedded<>(NbkGame.getInstance());
    panelMap.put("Hidden", hiddenPanel);
    
    dicePanel = new DicePanel();
    controllers.add(dicePanel);
    panelMap.put("Dice", dicePanel);

    entityPanel = new NbkEntityPanelEmbedded();
    controllers.add(entityPanel);
    panelMap.put("Entity", entityPanel);

    addPanels();
  }
}
