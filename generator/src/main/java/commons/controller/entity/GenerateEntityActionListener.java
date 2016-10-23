package commons.controller.entity;

import commons.controller.commons.GenerateActionListener;
import commons.model.commons.Game;
import commons.model.commons.GenerationConstraint;
import commons.model.entity.Entity;
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
public abstract class GenerateEntityActionListener<G extends Game, GC extends GenerationConstraint>
    extends GenerateActionListener<EntityOptionRow<G, GC>, EntityResultRow, EntityResult, String, GC> {

  protected GenerateEntityActionListener(EntityOptionRow<G, GC> entityOptionRow, EntityResultRow entityResultRow,
                                         EntityController<G, GC> entityController) {
    super(entityOptionRow, entityResultRow, entityController);
  }

  @Override
  protected Collection<EntityResult> generateResult(GC generalConstraint) {
    List<EntityResult> results = new ArrayList<>();
    IntStream.rangeClosed(1, optionRow.getNumberOfEntitiesSelected())
        .forEach(i -> results.add(generateOneResult(generalConstraint)));
    return results;
  }

  protected abstract EntityResult generateOneResult(GC generationConstraint);

  protected abstract Entity<G> generate(GC generationConstraint)
      throws NoAvailableEntityTypeException;

}
