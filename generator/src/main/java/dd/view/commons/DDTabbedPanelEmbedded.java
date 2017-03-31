package dd.view.commons;

import commons.view.commons.game.GameTabbedPanelEmbedded;
import commons.view.entity.EntityPanel;
import dd.model.commons.DDGame;
import dd.view.entity.items.options.EDDAvailableItemsRow;

import static commons.Constants.resourceBundle;

/**
 * Created by Germain on 25/10/2016.
 */
public class DDTabbedPanelEmbedded extends GameTabbedPanelEmbedded<DDGame> {

  private final EntityPanel<DDGame, EDDAvailableItemsRow> itemsPanel;

  public DDTabbedPanelEmbedded() {
    super(DDGame.getInstance());

    itemsPanel = new EntityPanel<>(EDDAvailableItemsRow.values());
    controllers.add(itemsPanel);
    panelMap.put(resourceBundle.getString("panel.item"), itemsPanel);

    addPanels();
  }
}
