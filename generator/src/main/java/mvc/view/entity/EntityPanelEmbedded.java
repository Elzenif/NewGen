package mvc.view.entity;

import mvc.model.entity.enums.EAvailableItem;
import mvc.model.entity.enums.EGame;
import mvc.view.MainFrame;
import mvc.view.commons.DoublePanel;
import mvc.view.entity.nbk.NbkEntityOptionRow;
import utils.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Germain on 09/06/2016.
 */
class EntityPanelEmbedded extends DoublePanel<EntityOptionRow, EntityResultRow> {

  private final EGame game;
  private final List<Pair<EntityOptionRow, EntityResultRow>> rowPairs = new ArrayList<>(EAvailableItem.values().length);

  EntityPanelEmbedded(EGame game) {
    super(setPanel("Options", EAvailableItem.values().length),
            setPanel("Results", EAvailableItem.values().length));
    this.game = game;

    setPanelsComponents();
    add(leftPanel);
    add(rightPanel);
  }

  private void setPanelsComponents() {
    for (EAvailableItem availableItem : EAvailableItem.values()) {
      EntityOptionRow entityOptionRow = new NbkEntityOptionRow(availableItem);
      EntityResultRow entityResultRow = new EntityResultRow(availableItem);
      rowPairs.add(new Pair<>(entityOptionRow, entityResultRow));
      leftPanel.add(entityOptionRow);
      rightPanel.add(entityResultRow);
    }
  }

  @Override
  public void setControllers(MainFrame view) {
    super.setControllers(rowPairs);
  }
}
