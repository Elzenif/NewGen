package mvc.controller.entity;

import mvc.model.entity.Item;
import mvc.model.entity.RandomlyGeneratedWeapon;
import mvc.model.entity.Weapon;
import mvc.model.entity.results.EItemResultRarity;
import mvc.model.entity.results.ItemResult;
import mvc.model.entity.utils.Constraints;
import mvc.view.entity.EntityOptionRow;
import mvc.view.entity.EntityResultRow;
import utils.exception.WrongClassException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by Germain on 04/06/2016.
 */
public class GenerateItemActionListener implements ActionListener {

  private final EntityOptionRow entityOptionRow;
  private final EntityResultRow entityResultRow;
  private final Class<? extends Item> itemClass;

  public GenerateItemActionListener(EntityOptionRow entityOptionRow, EntityResultRow entityResultRow,
                                    Class<? extends Item> itemClass) {
    this.entityOptionRow = entityOptionRow;
    this.entityResultRow = entityResultRow;
    this.itemClass = itemClass;
  }

  public void actionPerformed(ActionEvent e) {
    entityResultRow.clearResults();
    try {
      entityResultRow.setResultsToPrint(generate(entityOptionRow.getNumberOfItemsSelected(), getConstraints()));
    } catch (WrongClassException e1) {
      e1.printStackTrace();
    }
  }

  private Constraints getConstraints() {
    return entityOptionRow.isConstraintsCheckBoxSelected()
            ? entityOptionRow.getConstraints()
            : new Constraints();
  }

  private Collection<ItemResult> generate(int numberOfItems, Constraints constraints) throws WrongClassException {
    List<ItemResult> results = new ArrayList<>(numberOfItems);
    IntStream.rangeClosed(1, entityOptionRow.getNumberOfItemsSelected())
            .forEach(i -> results.add(generate(itemClass, constraints)));
    return results;
  }

  private ItemResult generate(Class<? extends Item> clazz, Constraints constraints) throws WrongClassException {
    Item item = null;
    if (clazz == Weapon.class) {
      item = RandomlyGeneratedWeapon.createWeapon(constraints);
    }
    if (item != null) {
      return new ItemResult(item.toString(), EItemResultRarity.getItemResultRarity(item.getRarity()));
    } else {
      throw new WrongClassException(clazz.getName());
    }
  }

}
