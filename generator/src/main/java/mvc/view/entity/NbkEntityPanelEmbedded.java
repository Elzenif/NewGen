package mvc.view.entity;

import mvc.model.entity.enums.ENbkAvailableItem;
import mvc.model.entity.game.NbkGame;
import utils.Pair;

/**
 * Created by Germain on 12/06/2016.
 */
class NbkEntityPanelEmbedded extends EntityPanelEmbedded {

  NbkEntityPanelEmbedded() {
    super(NbkGame.getInstance());

    for (ENbkAvailableItem availableItem : ENbkAvailableItem.values()) {
      EntityOptionRow entityOptionRow = new NbkEntityOptionRow(availableItem);
      EntityResultRow entityResultRow = new EntityResultRow(availableItem);
      rowPairs.add(new Pair<>(entityOptionRow, entityResultRow));
      leftPanel.add(entityOptionRow);
      rightPanel.add(entityResultRow);
    }
    add(leftPanel);
    add(rightPanel);
  }
}
