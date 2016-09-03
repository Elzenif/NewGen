package nbk.controller.entity.living;

import commons.controller.entity.EntityController;
import commons.model.entity.constraints.GlobalConstraints;
import commons.utils.exception.NoAvailableEntityTypeException;
import commons.view.entity.EntityOptionRow;
import commons.view.entity.EntityResultRow;
import nbk.model.commons.NbkGame;
import nbk.model.entity.living.NbkHumanoid;

/**
 * Created by Germain on 28/08/2016.
 */
public class GenerateNbkHumanoidActionListener extends GenerateNbkLivingActionListener {

  protected GenerateNbkHumanoidActionListener(EntityController<NbkGame> entityController,
                                              EntityOptionRow<NbkGame> entityOptionRow,
                                              EntityResultRow entityResultRow) {
    super(entityController, entityOptionRow, entityResultRow);
  }

  @Override
  protected NbkHumanoid generate(GlobalConstraints globalConstraints) throws NoAvailableEntityTypeException {
    return NbkHumanoid.create(globalConstraints);
  }
}
