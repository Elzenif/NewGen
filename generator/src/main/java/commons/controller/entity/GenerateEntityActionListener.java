package commons.controller.entity;

import commons.controller.commons.GenerateActionListener;
import commons.model.commons.Game;
import commons.model.entity.Entity;
import commons.model.entity.constraints.GlobalConstraints;
import commons.utils.exception.NoAvailableEntityTypeException;
import commons.view.entity.EntityOptionRow;
import commons.view.entity.EntityResultRow;
import commons.view.entity.results.EntityResult;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by Germain on 04/06/2016.
 */
public abstract class GenerateEntityActionListener<G extends Game>
    extends GenerateActionListener<EntityOptionRow<G>, EntityResultRow, EntityResult, String, GlobalConstraints> {

  protected GenerateEntityActionListener(EntityOptionRow<G> entityOptionRow, EntityResultRow entityResultRow,
                                         EntityController<G> entityController) {
    super(entityOptionRow, entityResultRow, entityController);
  }

  @Override
  protected GlobalConstraints newConstraint() {
    return new GlobalConstraints();
  }

  @Override
  protected Collection<EntityResult> generateResult(GlobalConstraints globalConstraints) {
    List<EntityResult> results = new ArrayList<>();
    IntStream.rangeClosed(1, optionRow.getNumberOfEntitiesSelected())
        .forEach(i -> results.add(generateOneResult(globalConstraints)));
    return results;
  }

  protected abstract EntityResult generateOneResult(GlobalConstraints globalConstraints);

  protected abstract Entity<G> generate(GlobalConstraints globalConstraints)
      throws NoAvailableEntityTypeException;

}
