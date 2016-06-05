package mvc.view.entity;

import mvc.controller.entity.GenerateItemActionListener;
import mvc.model.commons.Result;
import mvc.model.entity.Item;
import mvc.model.entity.enums.EAvailableItem;
import mvc.view.commons.PanelRow;
import utils.StringUtils;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 * Created by Germain on 05/06/2016.
 */
public class EntityOptionRow<S extends Item, T extends Result> extends PanelRow {

  private final int JLABEL_SIZE = 10;
  private final Class<? extends Item> itemClass;

  private final String itemName;

  private JSpinner numberOfItemSpinner;
  private SpinnerNumberModel numberOfItemModel;

  private JLabel infoLabel;

  private JButton generateItemButton;

  EntityOptionRow(EAvailableItem availableItem) {
    super();
    this.itemName = availableItem.getName();
    this.itemClass = availableItem.getItemClass();
    setComponents();
  }

  private void setComponents() {
    numberOfItemModel = new SpinnerNumberModel(1, 1 , 9, 1);
    numberOfItemSpinner = new JSpinner(numberOfItemModel);
    add(numberOfItemSpinner);

    infoLabel = new JLabel(StringUtils.center(JLABEL_SIZE, itemName));
    add(infoLabel);

    generateItemButton = new JButton("Generate");
    add(generateItemButton);
  }

  void setControllers(EntityResultRow<T> entityResultRow) {
    generateItemButton.addActionListener(new GenerateItemActionListener<>(this, entityResultRow, itemClass));
  }

}
