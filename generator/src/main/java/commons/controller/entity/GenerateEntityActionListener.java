package commons.controller.entity;

import commons.controller.commons.GenerateActionListener;
import commons.model.commons.Game;
import commons.model.commons.constraints.GenerationConstraints;
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
public abstract class GenerateEntityActionListener<G extends Game>
    extends GenerateActionListener<EntityOptionRow<G>, EntityResultRow, EntityResult, String> {

  protected GenerateEntityActionListener(EntityOptionRow<G> entityOptionRow, EntityResultRow entityResultRow,
                                         EntityController<G> entityController) {
    super(entityOptionRow, entityResultRow, entityController);
  }

  @Override
  protected Collection<EntityResult> generateResult(GenerationConstraints generationConstraints) {
    List<EntityResult> results = new ArrayList<>();
    IntStream.rangeClosed(1, optionRow.getNumberOfEntitiesSelected())
        .forEach(i -> results.add(generateOneResult(generationConstraints)));
    return results;
  }

  protected abstract EntityResult generateOneResult(GenerationConstraints generationConstraints);

  protected abstract Entity generate(GenerationConstraints generationConstraints)
      throws NoAvailableEntityTypeException;

}
