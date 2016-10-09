package nbk.view.commons;

import commons.view.commons.game.GameTabbedPanelEmbedded;
import commons.view.dice.DicePanel;
import commons.view.entity.EntityPanel;
import commons.view.hidden.HiddenPanel;
import commons.view.map.MapPanel;
import commons.view.utility.UtilityPanel;
import nbk.model.commons.NbkGame;
import nbk.view.entity.items.options.ENbkAvailableItemsRow;
import nbk.view.entity.living.options.ENbkAvailableLivingsRow;
import nbk.view.utility.options.ENbkAvailableUtilityRow;

import static commons.view.utils.Constants.resourceBundle;

/**
 * Created by Germain on 24/07/2016.
 */
public class NbkTabbedPanelEmbedded extends GameTabbedPanelEmbedded<NbkGame> {

  private final HiddenPanel<NbkGame> hiddenPanel;
  private final DicePanel dicePanel;
  private final EntityPanel<NbkGame, ENbkAvailableItemsRow> itemsPanel;
  private final UtilityPanel<ENbkAvailableUtilityRow> utilityPanel;
  private final EntityPanel<NbkGame, ENbkAvailableLivingsRow> livingsPanel;
  private final MapPanel mapPanel;

  public NbkTabbedPanelEmbedded() {
    hiddenPanel = new HiddenPanel<>(NbkGame.getInstance());
    panelMap.put(resourceBundle.getString("panel.hidden"), hiddenPanel);

    dicePanel = new DicePanel();
    controllers.add(dicePanel);
    panelMap.put(resourceBundle.getString("panel.dice"), dicePanel);

    itemsPanel = new EntityPanel<>(ENbkAvailableItemsRow.values());
    controllers.add(itemsPanel);
    panelMap.put(resourceBundle.getString("panel.item"), itemsPanel);

    livingsPanel = new EntityPanel<>(ENbkAvailableLivingsRow.values());
    controllers.add(livingsPanel);
    panelMap.put(resourceBundle.getString("panel.living"), livingsPanel);

    utilityPanel = new UtilityPanel<>(ENbkAvailableUtilityRow.values());
    controllers.add(utilityPanel);
    panelMap.put(resourceBundle.getString("panel.utility"), utilityPanel);

    mapPanel = new MapPanel();
    controllers.add(mapPanel);
    panelMap.put(resourceBundle.getString("panel.map"), mapPanel);

    addPanels();
  }
}
