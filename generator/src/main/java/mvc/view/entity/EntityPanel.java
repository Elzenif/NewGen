package mvc.view.entity;

import mvc.model.commons.Result;
import mvc.model.entity.Item;
import mvc.model.entity.enums.EAvailableItem;
import mvc.view.commons.DoublePanel;

/**
 * Created by Germain on 04/06/2016.
 */
public class EntityPanel extends DoublePanel {

  public EntityPanel() {
    super(setPanel("Options", EAvailableItem.values().length),
            setPanel("Results", EAvailableItem.values().length));
  }

  protected void setPanelsComponents() {
    for (EAvailableItem availableItem: EAvailableItem.values()) {
      EntityOptionRow<Item, Result> entityOptionRow = new EntityOptionRow<>(availableItem);
      EntityResultRow<Result> entityResultRow = new EntityResultRow<>(availableItem);
      entityOptionRow.setControllers(entityResultRow);
      leftPanel.add(entityOptionRow);
      rightPanel.add(entityResultRow);
    }

  }

}
