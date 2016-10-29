package nbk.controller.entity.living;

import commons.controller.entity.GenerateEntityActionListener;
import commons.controller.entity.living.LivingController;
import commons.model.commons.constraints.GenerationConstraints;
import commons.model.entity.living.Living;
import commons.view.entity.EntityResultRow;
import commons.view.entity.results.living.LivingResult;
import nbk.model.commons.NbkGame;
import nbk.view.entity.living.options.NbkLivingOptionRow;

/**
 * Created by Germain on 28/08/2016.
 */
public abstract class GenerateNbkLivingActionListener extends GenerateEntityActionListener<NbkGame> {

  protected GenerateNbkLivingActionListener(LivingController<NbkGame> livingController,
                                            NbkLivingOptionRow livingOptionRow, EntityResultRow entityResultRow) {
    super(livingOptionRow, entityResultRow, livingController);
  }

  @Override
  protected LivingResult generateOneResult(GenerationConstraints drawKeyConstraint) {
    Living living = generate(drawKeyConstraint);
    return new LivingResult(living);
  }

  protected abstract Living<NbkGame> generate(GenerationConstraints drawKeyConstraint);
}
