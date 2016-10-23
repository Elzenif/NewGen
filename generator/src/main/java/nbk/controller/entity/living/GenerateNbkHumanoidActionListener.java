package nbk.controller.entity.living;

import commons.model.commons.constraints.GenerationConstraints;
import commons.utils.exception.NoAvailableEntityTypeException;
import commons.utils.exception.StatNotInRangeException;
import commons.view.entity.EntityResultRow;
import nbk.model.entity.living.NbkHumanoid;
import nbk.model.entity.living.characteristics.primary.Stats;
import nbk.view.entity.living.options.NbkHumanoidOptionRow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Germain on 28/08/2016.
 */
public class GenerateNbkHumanoidActionListener extends GenerateNbkLivingActionListener {

  private static final Logger LOGGER = LoggerFactory.getLogger(GenerateNbkHumanoidActionListener.class);

  protected GenerateNbkHumanoidActionListener(NbkHumanoidOptionRow humanoidOptionRow, EntityResultRow entityResultRow,
                                              NbkHumanoidController humanoidController) {
    super(humanoidController, humanoidOptionRow, entityResultRow);
  }

  @SuppressWarnings("HardCodedStringLiteral")
  @Override
  protected NbkHumanoid generate(GenerationConstraints generationConstraints) throws NoAvailableEntityTypeException {
    if (optionRow.isConstraintsCheckBoxSelected()) {
      Stats stats;
      try {
        // TODO see for making stats a drawKeyConstraint ?
        stats = new Stats(generationConstraints.getDrawKeyConstraint());
      } catch (StatNotInRangeException e) {
        LOGGER.error("Constraints are not suitable for stats construction");
        e.printStackTrace();
        throw new NoAvailableEntityTypeException();
      }
      return NbkHumanoid.create(stats);
    } else {
      return NbkHumanoid.create();
    }
  }
}
