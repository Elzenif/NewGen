package nbk.controller.entity;

import commons.controller.entity.GenerateItemActionListener;
import commons.model.entity.constraints.GlobalConstraints;
import commons.model.entity.items.Item;
import commons.model.entity.utils.ERarity;
import commons.utils.MathUtils;
import commons.utils.exception.NoAvailableItemTypeException;
import commons.view.entity.EntityResultRow;
import nbk.model.entity.game.NbkGame;
import nbk.model.entity.items.NbkPredefinedWeapon;
import nbk.model.entity.items.NbkRGWeapon;
import nbk.view.entity.NbkWeaponOptionRow;

/**
 * Created by Germain on 14/06/2016.
 */
public class GenerateNbkWeaponActionListener extends GenerateItemActionListener<NbkGame> {

  public GenerateNbkWeaponActionListener(NbkWeaponOptionRow entityOptionRow, EntityResultRow entityResultRow) {
    super(entityOptionRow, entityResultRow);
  }

  @Override
  protected Item generate(GlobalConstraints globalConstraints, ERarity rarity) {
    if (MathUtils.random(1, 10) == 1) {
      return generatePW(globalConstraints, rarity);
    } else {
      return generateRGW(globalConstraints, rarity);
    }
  }

  private Item generatePW(GlobalConstraints globalConstraints, ERarity rarity) {
    try {
      return NbkPredefinedWeapon.create(globalConstraints, rarity);
    } catch (NoAvailableItemTypeException e) {
      // if no one fits the constraints, generate a random weapon anyway
      return generateRGW(globalConstraints, rarity);
    }
  }

  private Item generateRGW(GlobalConstraints globalConstraints, ERarity rarity) {
    try {
      return NbkRGWeapon.create(globalConstraints, rarity);
    } catch (NoAvailableItemTypeException e) {
      e.printStackTrace();
      return new Item(ERarity.COMMON) {
        @Override
        public String toString() {
          return "No weapon available with given conditions";
        }
      };
    }
  }
}
