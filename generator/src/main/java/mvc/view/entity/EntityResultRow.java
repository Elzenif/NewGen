package mvc.view.entity;

import mvc.view.commons.PanelRow;

import javax.swing.JLabel;

/**
 * Created by Germain on 05/06/2016.
 */
public class EntityResultRow extends PanelRow {

  private JLabel resultItem;

  EntityResultRow() {
    setComponents();
  }

  private void setComponents() {
    resultItem = new JLabel();
    add(resultItem);
  }

  public void printItem(String info) {
    resultItem.setText(info);
  }

}
