package nbk.controller.entity.living;

import commons.model.commons.constraints.GenerationConstraints;
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

  @SuppressWarnings("HardCodedStringLiteral")
  @Override
  protected NbkHumanoid generate(GenerationConstraints generationConstraints) {
    if (optionRow.isConstraintsCheckBoxSelected()) {
      return NbkHumanoid.create(generationConstraints);
    } else {
      return NbkHumanoid.create();
    }
  }
}
