package nbk.controller.entity.items;

import commons.controller.entity.items.ItemController;
import commons.model.commons.constraints.PredicateConstraints;
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
                                         ItemController<NbkGame> entityController) {
    super(entityOptionRow, entityResultRow, entityController);
  }

  @Contract("_ -> !null")
  @Override
  protected NbkAbstractWeapon generate(PredicateConstraints predicateConstraints) throws NoAvailableEntityTypeException {
    if (MathUtils.random(1, 10) == 1) {
      return generatePW(predicateConstraints);
    } else {
      return generateRGW(predicateConstraints);
    }
  }

  @Contract("_ -> !null")
  private NbkAbstractWeapon generatePW(PredicateConstraints predicateConstraints) throws NoAvailableEntityTypeException {
    try {
      return NbkPredefinedWeapon.create(predicateConstraints);
    } catch (NoAvailableEntityTypeException e) {
      // if no one fits the constraints, generate a random weapon anyway
      return generateRGW(predicateConstraints);
    }
  }

  @Contract("_ -> !null")
  private NbkRGWeapon generateRGW(PredicateConstraints predicateConstraints) throws NoAvailableEntityTypeException {
    return NbkRGWeapon.create(predicateConstraints);
  }
}
