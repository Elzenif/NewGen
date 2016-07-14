package nbk.controller.entity;

import commons.controller.entity.GenerateItemActionListener;
import commons.model.entity.characteristics.primary.enums.ERarity;
import commons.model.entity.constraints.GlobalConstraints;
import commons.utils.MathUtils;
import commons.utils.exception.NoAvailableItemTypeException;
import commons.view.entity.EntityResultRow;
import nbk.model.entity.game.NbkGame;
import nbk.model.entity.items.NbkAbstractWeapon;
import nbk.model.entity.items.NbkPredefinedWeapon;
import nbk.model.entity.items.NbkRGWeapon;
import nbk.view.entity.NbkWeaponOptionRow;
import org.jetbrains.annotations.Contract;

/**
 * Created by Germain on 14/06/2016.
 */
public class GenerateNbkWeaponActionListener extends GenerateItemActionListener<NbkGame> {

  public GenerateNbkWeaponActionListener(NbkWeaponOptionRow entityOptionRow, EntityResultRow entityResultRow) {
    super(entityOptionRow, entityResultRow);
  }

  @Contract("_, _ -> !null")
  @Override
  protected NbkAbstractWeapon generate(GlobalConstraints globalConstraints, ERarity rarity) throws NoAvailableItemTypeException {
    if (MathUtils.random(1, 10) == 1) {
      return generatePW(globalConstraints, rarity);
    } else {
      return generateRGW(globalConstraints, rarity);
    }
  }

  @Contract("_, _ -> !null")
  private NbkAbstractWeapon generatePW(GlobalConstraints globalConstraints, ERarity rarity) throws NoAvailableItemTypeException {
    try {
      return NbkPredefinedWeapon.create(globalConstraints, rarity);
    } catch (NoAvailableItemTypeException e) {
      // if no one fits the constraints, generate a random weapon anyway
      return generateRGW(globalConstraints, rarity);
    }
  }

  @Contract("_, _ -> !null")
  private NbkRGWeapon generateRGW(GlobalConstraints globalConstraints, ERarity rarity) throws NoAvailableItemTypeException {
    return NbkRGWeapon.create(globalConstraints, rarity);
  }
}
