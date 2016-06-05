package mvc.controller.entity;

import mvc.model.commons.Result;
import mvc.model.entity.Item;
import mvc.model.entity.Weapon;
import mvc.model.entity.results.WeaponResult;
import mvc.view.entity.EntityOptionRow;
import mvc.view.entity.EntityResultRow;
import org.jetbrains.annotations.Nullable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Germain on 04/06/2016.
 */
public class GenerateItemActionListener<S extends Item, T extends Result>
        implements ActionListener {

  private final EntityOptionRow<S, T> entityOptionRow;
  private final EntityResultRow<T> entityResultRow;
  private final Class<? extends Item> itemClass;

  public GenerateItemActionListener(EntityOptionRow<S, T> entityOptionRow, EntityResultRow<T> entityResultRow,
                                    Class<? extends Item> itemClass) {
    this.entityOptionRow = entityOptionRow;
    this.entityResultRow = entityResultRow;
    this.itemClass = itemClass;
  }

  public void actionPerformed(ActionEvent e) {
    entityResultRow.clearResults();
    List<T> results = new LinkedList<>();
    // check options
    T result = generate(itemClass);
    results.add(result);
    entityResultRow.setResultsToPrint(results);
  }

  @SuppressWarnings("unchecked")
  @Nullable
  private T generate(Class<? extends Item> clazz) {
    if (clazz == Weapon.class) {
      return (T) new WeaponResult(generateWeapon().toString());
    }
    return null;
  }

  private Weapon generateWeapon() {
    return Weapon.createWeaponWithoutConstraints();
  }
}
