package mvc.view.entity;

import mvc.model.commons.Result;
import mvc.model.entity.enums.EAvailableItem;
import mvc.view.commons.ResultRow;

import javax.swing.JLabel;

/**
 * Created by Germain on 05/06/2016.
 */
public class EntityResultRow<T extends Result> extends ResultRow<T> {

  private final EAvailableItem availableItem;

  EntityResultRow(EAvailableItem availableItem) {
    super(availableItem.getName());
    this.availableItem = availableItem;
  }

  @Override
  protected void makePretty(JLabel resultToPrint, T result) {

  }
}
