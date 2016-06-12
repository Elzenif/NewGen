package mvc.view.entity;

import mvc.model.entity.enums.ETesAvailableItem;
import mvc.model.entity.game.TesGame;
import utils.Pair;

/**
 * Created by Germain on 12/06/2016.
 */
class TesEntityPanelEmbedded extends EntityPanelEmbedded {

  TesEntityPanelEmbedded() {
    super(TesGame.getInstance());

    for (ETesAvailableItem availableItem : ETesAvailableItem.values()) {
      EntityOptionRow entityOptionRow = new TesEntityOptionRow(availableItem);
      EntityResultRow entityResultRow = new EntityResultRow(availableItem);
      rowPairs.add(new Pair<>(entityOptionRow, entityResultRow));
      leftPanel.add(entityOptionRow);
      rightPanel.add(entityResultRow);
    }
    add(leftPanel);
    add(rightPanel);
  }
}
