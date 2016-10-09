package nbk.controller.entity.items;

import commons.controller.entity.EntityController;
import commons.model.entity.constraints.GlobalConstraints;
import commons.utils.MathUtils;
import commons.utils.exception.NoAvailableEntityTypeException;
import commons.view.entity.EntityResultRow;
import nbk.model.commons.NbkGame;
import nbk.model.entity.items.NbkAbstractWeapon;
import nbk.model.entity.items.NbkPredefinedWeapon;
import nbk.model.entity.items.NbkRGWeapon;
import nbk.view.entity.items.options.NbkWeaponOptionRow;
import org.jetbrains.annotations.Contract;

/**
 * Created by Germain on 14/06/2016.
 */
public class GenerateNbkWeaponActionListener extends GenerateNbkItemActionListener {

  public GenerateNbkWeaponActionListener(NbkWeaponOptionRow entityOptionRow, EntityResultRow entityResultRow,
                                         EntityController<NbkGame> entityController) {
    super(entityOptionRow, entityResultRow, entityController);
  }

  @Contract("_ -> !null")
  @Override
  protected NbkAbstractWeapon generate(GlobalConstraints globalConstraints) throws NoAvailableEntityTypeException {
    if (MathUtils.random(1, 10) == 1) {
      return generatePW(globalConstraints);
    } else {
      return generateRGW(globalConstraints);
    }
  }

  @Contract("_ -> !null")
  private NbkAbstractWeapon generatePW(GlobalConstraints globalConstraints) throws NoAvailableEntityTypeException {
    try {
      return NbkPredefinedWeapon.create(globalConstraints);
    } catch (NoAvailableEntityTypeException e) {
      // if no one fits the constraints, generate a random weapon anyway
      return generateRGW(globalConstraints);
    }
  }

  @Contract("_ -> !null")
  private NbkRGWeapon generateRGW(GlobalConstraints globalConstraints) throws NoAvailableEntityTypeException {
    return NbkRGWeapon.create(globalConstraints);
  }
}
