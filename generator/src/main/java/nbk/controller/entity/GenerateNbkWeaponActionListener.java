package nbk.controller.entity;

import commons.controller.entity.GenerateItemActionListener;
import commons.controller.entity.ItemController;
import commons.model.entity.constraints.GlobalConstraints;
import commons.utils.MathUtils;
import commons.utils.exception.NoAvailableItemTypeException;
import commons.view.entity.EntityResultRow;
import nbk.model.commons.NbkGame;
import nbk.model.entity.items.NbkAbstractWeapon;
import nbk.model.entity.items.NbkPredefinedWeapon;
import nbk.model.entity.items.NbkRGWeapon;
import nbk.view.entity.NbkWeaponOptionRow;
import org.jetbrains.annotations.Contract;

/**
 * Created by Germain on 14/06/2016.
 */
public class GenerateNbkWeaponActionListener extends GenerateItemActionListener<NbkGame> {

  public GenerateNbkWeaponActionListener(ItemController<NbkGame> itemController, NbkWeaponOptionRow entityOptionRow,
                                         EntityResultRow entityResultRow) {
    super(itemController, entityOptionRow, entityResultRow);
  }

  @Contract("_ -> !null")
  @Override
  protected NbkAbstractWeapon generate(GlobalConstraints globalConstraints) throws NoAvailableItemTypeException {
    if (MathUtils.random(1, 10) == 1) {
      return generatePW(globalConstraints);
    } else {
      return generateRGW(globalConstraints);
    }
  }

  @Contract("_ -> !null")
  private NbkAbstractWeapon generatePW(GlobalConstraints globalConstraints) throws NoAvailableItemTypeException {
    try {
      return NbkPredefinedWeapon.create(globalConstraints);
    } catch (NoAvailableItemTypeException e) {
      // if no one fits the constraints, generate a random weapon anyway
      return generateRGW(globalConstraints);
    }
  }

  @Contract("_ -> !null")
  private NbkRGWeapon generateRGW(GlobalConstraints globalConstraints) throws NoAvailableItemTypeException {
    return NbkRGWeapon.create(globalConstraints);
  }
}
