package mvc.view.entity;

import mvc.model.entity.results.ItemResult;
import mvc.view.commons.ResultRow;

import javax.swing.JLabel;

/**
 * Created by Germain on 05/06/2016.
 */
public class EntityResultRow extends ResultRow<ItemResult> {

  EntityResultRow(IAvailableItem availableItem) {
    super((String) availableItem.getName());
  }

  @Override
  protected void makePretty(JLabel resultToPrint, ItemResult result) {
    resultToPrint.setForeground(result.getItemResultRarity().getColor());
  }
}
