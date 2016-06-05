package mvc.controller.entity;

import mvc.model.entity.Item;
import mvc.model.entity.Weapon;
import mvc.model.entity.results.ItemResult;
import mvc.model.entity.results.WeaponResult;
import mvc.view.entity.EntityOptionRow;
import mvc.view.entity.EntityResultRow;
import utils.exception.WrongClassException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

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
    Set<Integer> numbers = new HashSet<>(entityOptionRow.getNumberOfItemSelected());
    Queue<ItemResult> results = new ConcurrentLinkedQueue<>();
    // check options
    for (int i = 0; i < entityOptionRow.getNumberOfItemSelected(); i++) {
      numbers.add(i);
    }
    numbers.parallelStream().forEach(itemResult -> {
      try {
        results.add(generate(itemClass));
      } catch (WrongClassException e1) {
        e1.printStackTrace();
      }
    });
    entityResultRow.setResultsToPrint(results);
  }

  @SuppressWarnings("unchecked")
  private ItemResult generate(Class<? extends Item> clazz) throws WrongClassException {
    Item item;
    if (clazz == Weapon.class) {
      item = generateWeapon();
      return new WeaponResult(item.toString());
    }
    throw new WrongClassException(clazz.getName());
  }

  private Weapon generateWeapon() {
    return Weapon.createWeaponWithoutConstraints();
  }
}
