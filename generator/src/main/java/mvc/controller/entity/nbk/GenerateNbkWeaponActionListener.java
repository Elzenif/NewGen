package mvc.controller.entity.nbk;

import mvc.controller.entity.GenerateItemActionListener;
import mvc.model.entity.constraints.GlobalConstraints;
import mvc.model.entity.game.NbkGame;
import mvc.model.entity.items.Item;
import mvc.model.entity.items.NbkWeapon;
import mvc.view.entity.EntityResultRow;
import mvc.view.entity.nbk.NbkWeaponOptionRow;

/**
 * Created by Germain on 14/06/2016.
 */
public class GenerateNbkWeaponActionListener extends GenerateItemActionListener<NbkGame> {

  public GenerateNbkWeaponActionListener(NbkWeaponOptionRow entityOptionRow, EntityResultRow entityResultRow) {
    super(entityOptionRow, entityResultRow);
  }

  @Override
  protected Item<NbkGame> generate(GlobalConstraints globalConstraints) {
    return NbkWeapon.create(globalConstraints);
  }
}
