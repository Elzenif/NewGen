package mvc.view.entity;

import mvc.model.entity.game.Game;
import mvc.view.MainFrame;
import mvc.view.commons.DoublePanel;
import utils.Pair;

import java.util.ArrayList;
import java.util.List;

import static utils.CollectionUtils.setMaxSize;

/**
 * Created by Germain on 09/06/2016.
 */
public abstract class EntityPanelEmbedded<S extends Game, T extends IAvailableItem<S>>
        extends DoublePanel<EntityOptionRow<S>, EntityResultRow> {

  private final List<Pair<EntityOptionRow<S>, EntityResultRow>> rowPairs;

  protected EntityPanelEmbedded(S game, T[] availableItems) {
    super(setPanel("Options", IAvailableItem.getValues(game.getAvailableItems()).size()),
            setPanel("Results", IAvailableItem.getValues(game.getAvailableItems()).size()));

    rowPairs = setMaxSize(new ArrayList<>(), IAvailableItem.getValues(game.getAvailableItems()).size());
    for (IAvailableItem<S> availableItem : availableItems) {
      EntityOptionRow<S> entityOptionRow = availableItem.getEntityOptionRow();
      EntityResultRow entityResultRow = new EntityResultRow(availableItem);
      rowPairs.add(new Pair<>(entityOptionRow, entityResultRow));
      leftPanel.add(entityOptionRow);
      rightPanel.add(entityResultRow);
    }
    add(leftPanel);
    add(rightPanel);
  }

  @Override
  public void setControllers(MainFrame view) {
    super.setControllers(rowPairs);
  }
}
