package mvc.view.entity;

import mvc.controller.entity.GenerateItemActionListener;
import mvc.model.entity.Item;
import mvc.model.entity.enums.EAvailableItem;
import mvc.view.commons.OptionRow;
import utils.MathUtils;
import utils.StringUtils;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 * Created by Germain on 05/06/2016.
 */
public abstract class EntityOptionRow extends OptionRow<EntityResultRow> {

  private final int JLABEL_SIZE = MathUtils.maxLength(EAvailableItem.values());
  private final Class<? extends Item> itemClass;

  private final String itemName;

  private final JSpinner numberOfItemSpinner;
  private final SpinnerNumberModel numberOfItemModel;

  private final JLabel infoLabel;

  private final JButton generateItemButton;

  protected EntityOptionRow(EAvailableItem availableItem) {
    super();
    this.itemName = availableItem.getName();
    this.itemClass = availableItem.getItemClass();

    numberOfItemModel = new SpinnerNumberModel(1, 1 , 9, 1);
    numberOfItemSpinner = new JSpinner(numberOfItemModel);
    add(numberOfItemSpinner);

    infoLabel = new JLabel(StringUtils.leftAlign(JLABEL_SIZE, itemName));
    add(infoLabel);

    generateItemButton = new JButton("Generate");
    add(generateItemButton);
  }

  @Override
  public void setControllers(EntityResultRow entityResultRow) {
    generateItemButton.addActionListener(new GenerateItemActionListener(this, entityResultRow, itemClass));
  }

  public int getNumberOfItemSelected() {
    return numberOfItemModel.getNumber().intValue();
  }
}
