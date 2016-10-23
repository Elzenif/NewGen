package nbk.controller.entity.living;

import commons.controller.entity.GenerateEntityActionListener;
import commons.controller.entity.living.LivingController;
import commons.model.commons.IDrawKey;
import commons.model.entity.living.Living;
import commons.model.utility.constraints.DrawKeyConstraint;
import commons.utils.exception.NoAvailableEntityTypeException;
import commons.view.entity.EntityResultRow;
import commons.view.entity.results.living.LivingResult;
import nbk.model.commons.NbkGame;
import nbk.model.entity.living.characteristics.primary.EStat;
import nbk.view.entity.living.options.NbkLivingOptionRow;

/**
 * Created by Germain on 28/08/2016.
 */
public abstract class GenerateNbkLivingActionListener<K extends IDrawKey>
    extends GenerateEntityActionListener<NbkGame, DrawKeyConstraint> {

  protected GenerateNbkLivingActionListener(LivingController<NbkGame, K> livingController,
                                            NbkLivingOptionRow<EStat> livingOptionRow, EntityResultRow entityResultRow) {
    super(livingOptionRow, entityResultRow, livingController);
  }

  @Override
  protected DrawKeyConstraint newConstraint() {
    return new DrawKeyConstraint();
  }

  @Override
  protected LivingResult generateOneResult(DrawKeyConstraint drawKeyConstraint) {
    try {
      Living living = generate(drawKeyConstraint);
      return new LivingResult(living);
    } catch (NoAvailableEntityTypeException e) {
      e.printStackTrace();
      return new LivingResult(Living.stubbedLiving());
    }
  }

  @Override
  protected abstract Living<NbkGame> generate(DrawKeyConstraint drawKeyConstraint) throws NoAvailableEntityTypeException;
}
