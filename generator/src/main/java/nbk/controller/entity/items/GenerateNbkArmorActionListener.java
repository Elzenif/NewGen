package nbk.controller.entity.items;

import commons.controller.entity.EntityController;
import commons.model.entity.constraints.GlobalConstraints;
import commons.utils.exception.NoAvailableEntityTypeException;
import commons.view.entity.EntityResultRow;
import nbk.model.commons.NbkGame;
import nbk.model.entity.items.NbkPredefinedArmor;
import nbk.view.entity.items.NbkArmorOptionRow;
import org.jetbrains.annotations.Contract;

/**
 * Created by Germain on 26/06/2016.
 */
public class GenerateNbkArmorActionListener extends GenerateNbkItemActionListener {

  public GenerateNbkArmorActionListener(EntityController<NbkGame> entityController, NbkArmorOptionRow entityOptionRow,
                                        EntityResultRow entityResultRow) {
    super(entityController, entityOptionRow, entityResultRow);
  }

  @Contract("_ -> !null")
  @Override
  protected NbkPredefinedArmor generate(GlobalConstraints globalConstraints) throws NoAvailableEntityTypeException {
    return NbkPredefinedArmor.create(globalConstraints);
  }
}
