package nbk.controller.entity;

import commons.controller.entity.GenerateItemActionListener;
import commons.model.entity.constraints.GlobalConstraints;
import commons.model.entity.items.Item;
import commons.model.entity.utils.ERarity;
import commons.view.entity.EntityResultRow;
import nbk.model.entity.game.NbkGame;
import nbk.model.entity.items.NbkWeapon;
import nbk.view.entity.NbkWeaponOptionRow;

/**
 * Created by Germain on 14/06/2016.
 */
public class GenerateNbkWeaponActionListener extends GenerateItemActionListener<NbkGame> {

  public GenerateNbkWeaponActionListener(NbkWeaponOptionRow entityOptionRow, EntityResultRow entityResultRow) {
    super(entityOptionRow, entityResultRow);
  }

  @Override
  protected Item<NbkGame> generate(GlobalConstraints globalConstraints, ERarity rarity) {
    return NbkWeapon.create(globalConstraints, rarity);
  }
}
