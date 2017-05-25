package nbk.view.commons;

import commons.view.commons.game.GameTabbedPanelEmbedded;
import commons.view.entity.EntityPanel;
import commons.view.map.MapPanel;
import commons.view.utility.UtilityPanel;
import nbk.model.commons.NbkGame;
import nbk.view.entity.items.options.ENbkAvailableItemsRow;
import nbk.view.entity.living.options.ENbkAvailableLivingsRow;
import nbk.view.utility.options.ENbkAvailableUtilityRow;

import static commons.Constants.resourceBundle;

/**
 * Created by Germain on 24/07/2016.
 */
public class NbkTabbedPanelEmbedded extends GameTabbedPanelEmbedded {

  public NbkTabbedPanelEmbedded() {
    super(NbkGame.getInstance());

    EntityPanel<NbkGame, ENbkAvailableItemsRow> itemsPanel = new EntityPanel<>(ENbkAvailableItemsRow.values());
    controllers.add(itemsPanel);
    panelMap.put(resourceBundle.getString("panel.item"), itemsPanel);

    EntityPanel<NbkGame, ENbkAvailableLivingsRow> livingsPanel = new EntityPanel<>(ENbkAvailableLivingsRow.values());
    controllers.add(livingsPanel);
    panelMap.put(resourceBundle.getString("panel.living"), livingsPanel);

    UtilityPanel<ENbkAvailableUtilityRow> utilityPanel = new UtilityPanel<>(ENbkAvailableUtilityRow.values());
    controllers.add(utilityPanel);
    panelMap.put(resourceBundle.getString("panel.utility"), utilityPanel);

    MapPanel mapPanel = new MapPanel();
    controllers.add(mapPanel);
    panelMap.put(resourceBundle.getString("panel.map"), mapPanel);

    addPanels();
  }
}
