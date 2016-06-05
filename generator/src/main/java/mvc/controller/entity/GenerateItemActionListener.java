package mvc.controller.entity;

import mvc.model.entity.Weapon;
import mvc.view.entity.EntityOptionRow;
import mvc.view.entity.EntityResultRow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by Germain on 04/06/2016.
 */
public class GenerateItemActionListener implements ActionListener {

  private final EntityOptionRow entityOptionRow;
  private final List<EntityResultRow> entityResultRows;

  public GenerateItemActionListener(EntityOptionRow entityOptionRow, List<EntityResultRow> entityResultRows) {
    this.entityOptionRow = entityOptionRow;
    this.entityResultRows = entityResultRows;
  }

  public void actionPerformed(ActionEvent e) {
    // check options
    Weapon weapon = generateWeapon();
    entityResultRows.get(0).printItem(weapon.toString());
  }

  private Weapon generateWeapon() {
    return Weapon.createWeaponWithoutConstraints();
  }
}
