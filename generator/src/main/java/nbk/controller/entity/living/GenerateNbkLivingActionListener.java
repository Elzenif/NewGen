package nbk.controller.entity.living;

import commons.controller.entity.EntityController;
import commons.controller.entity.GenerateEntityActionListener;
import commons.model.entity.constraints.GlobalConstraints;
import commons.model.entity.living.Living;
import commons.utils.exception.NoAvailableEntityTypeException;
import commons.view.entity.EntityOptionRow;
import commons.view.entity.EntityResultRow;
import commons.view.entity.results.living.LivingResult;
import nbk.model.commons.NbkGame;

/**
 * Created by Germain on 28/08/2016.
 */
public abstract class GenerateNbkLivingActionListener extends GenerateEntityActionListener<NbkGame> {

  protected GenerateNbkLivingActionListener(EntityController<NbkGame> entityController,
                                            EntityOptionRow<NbkGame> entityOptionRow, EntityResultRow entityResultRow) {
    super(entityOptionRow, entityResultRow, entityController);
  }

  @Override
  protected LivingResult generateOneResult(GlobalConstraints globalConstraints) {
    try {
      Living living = generate(globalConstraints);
      return new LivingResult(living);
    } catch (NoAvailableEntityTypeException e) {
      e.printStackTrace();
      return new LivingResult(Living.stubbedLiving());
    }
  }

  @Override
  protected abstract Living<NbkGame> generate(GlobalConstraints globalConstraints) throws NoAvailableEntityTypeException;
}
