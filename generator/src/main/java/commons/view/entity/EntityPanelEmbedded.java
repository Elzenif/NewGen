package commons.view.entity;

import commons.model.commons.Game;
import commons.utils.CollectionUtils;
import commons.utils.Pair;
import commons.view.MainFrame;
import commons.view.utils.DoublePanel;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Germain on 09/06/2016.
 */
public abstract class EntityPanelEmbedded<T extends Game, S extends IAvailableEntityOptionRow<T>>
        extends DoublePanel<EntityOptionRow<T>, EntityResultRow> {

  private final Set<Pair<EntityOptionRow<T>, EntityResultRow>> rowPairs;

  protected EntityPanelEmbedded(S[] availableEntityOptionRows) {
    super(setPanel("Options", availableEntityOptionRows.length),
            setPanel("Results", availableEntityOptionRows.length));

    rowPairs = CollectionUtils.setMaxSizeSet(new HashSet<>(), availableEntityOptionRows.length);
    for (IAvailableEntityOptionRow<T> availableEntityOptionRow : availableEntityOptionRows) {
      EntityOptionRow<T> entityOptionRow = availableEntityOptionRow.getEntityOptionRow();
      EntityResultRow entityResultRow = new EntityResultRow(availableEntityOptionRow);
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
