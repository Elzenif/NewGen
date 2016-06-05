package mvc.view.entity;

import mvc.model.entity.enums.EAvailableItem;
import mvc.model.entity.results.ItemResult;
import mvc.view.commons.ResultRow;

import javax.swing.JLabel;

/**
 * Created by Germain on 05/06/2016.
 */
public class EntityResultRow extends ResultRow<ItemResult> {

  EntityResultRow(EAvailableItem availableItem) {
    super(availableItem.getName());
  }

  @Override
  protected void makePretty(JLabel resultToPrint, ItemResult result) {

  }
}
