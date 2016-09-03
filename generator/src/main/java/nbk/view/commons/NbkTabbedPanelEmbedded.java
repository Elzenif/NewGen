package nbk.view.commons;

import commons.view.commons.GameTabbedPanelEmbedded;
import commons.view.dice.DicePanel;
import commons.view.entity.EntityPanel;
import commons.view.hidden.HiddenPanel;
import commons.view.utility.UtilityPanel;
import nbk.model.commons.NbkGame;
import nbk.view.entity.items.ENbkAvailableItemsRow;
import nbk.view.entity.living.ENbkAvailableLivingsRow;
import nbk.view.utility.ENbkAvailableUtilityRow;

/**
 * Created by Germain on 24/07/2016.
 */
public class NbkTabbedPanelEmbedded extends GameTabbedPanelEmbedded<NbkGame> {

  private final HiddenPanel<NbkGame> hiddenPanel;
  private final DicePanel dicePanel;
  private final EntityPanel<NbkGame, ENbkAvailableItemsRow> itemsPanel;
  private final UtilityPanel<NbkGame, ENbkAvailableUtilityRow> utilityPanel;
  private final EntityPanel<NbkGame, ENbkAvailableLivingsRow> livingsPanel;

  public NbkTabbedPanelEmbedded() {
    hiddenPanel = new HiddenPanel<>(NbkGame.getInstance());
    panelMap.put("Hidden", hiddenPanel);
    
    dicePanel = new DicePanel();
    controllers.add(dicePanel);
    panelMap.put("Dice", dicePanel);

    itemsPanel = new EntityPanel<>(ENbkAvailableItemsRow.values());
    controllers.add(itemsPanel);
    panelMap.put("Item", itemsPanel);

    livingsPanel = new EntityPanel<>(ENbkAvailableLivingsRow.values());
    controllers.add(livingsPanel);
    panelMap.put("Living", livingsPanel);

    utilityPanel = new UtilityPanel<>(ENbkAvailableUtilityRow.values());
    controllers.add(utilityPanel);
    panelMap.put("Utility", utilityPanel);

    addPanels();
  }
}
