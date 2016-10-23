package nbk.controller.entity.living;

import commons.model.utility.constraints.DrawKeyConstraint;
import commons.utils.exception.NoAvailableEntityTypeException;
import commons.view.entity.EntityResultRow;
import nbk.model.entity.living.NbkHumanoid;
import nbk.view.entity.living.options.NbkHumanoidOptionRow;

/**
 * Created by Germain on 28/08/2016.
 */
public class GenerateNbkHumanoidActionListener extends GenerateNbkLivingActionListener {

  protected GenerateNbkHumanoidActionListener(NbkHumanoidOptionRow humanoidOptionRow, EntityResultRow entityResultRow,
                                              NbkHumanoidController humanoidController) {
    super(humanoidController, humanoidOptionRow, entityResultRow);
  }

  @Override
  protected NbkHumanoid generate(DrawKeyConstraint drawKeyConstraint) throws NoAvailableEntityTypeException {
    return NbkHumanoid.create();
  }
}
