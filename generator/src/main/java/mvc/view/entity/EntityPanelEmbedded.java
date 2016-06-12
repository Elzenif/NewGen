package mvc.view.entity;

import mvc.model.entity.game.Game;
import mvc.model.entity.utils.IAvailableItem;
import mvc.view.MainFrame;
import mvc.view.commons.DoublePanel;
import utils.Pair;

import java.util.ArrayList;
import java.util.List;

import static utils.CollectionUtils.setMaxSize;

/**
 * Created by Germain on 09/06/2016.
 */
class EntityPanelEmbedded extends DoublePanel<EntityOptionRow, EntityResultRow> {

  final List<Pair<EntityOptionRow, EntityResultRow>> rowPairs;

  EntityPanelEmbedded(Game game) {
    super(setPanel("Options", IAvailableItem.getValues(game.getAvailableItems()).size()),
            setPanel("Results", IAvailableItem.getValues(game.getAvailableItems()).size()));
    rowPairs = setMaxSize(new ArrayList<>(), IAvailableItem.getValues(game.getAvailableItems()).size());
  }

  @Override
  public void setControllers(MainFrame view) {
    super.setControllers(rowPairs);
  }
}
