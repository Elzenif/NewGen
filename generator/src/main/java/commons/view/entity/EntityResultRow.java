package commons.view.entity;

import commons.model.entity.results.ItemResult;
import commons.view.utils.ResultRow;

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
