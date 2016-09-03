package commons.controller.entity;

import commons.model.commons.Game;
import commons.model.entity.Entity;
import commons.model.entity.constraints.GlobalConstraints;
import commons.utils.exception.NoAvailableEntityTypeException;
import commons.utils.exception.WrongClassException;
import commons.view.entity.EntityOptionRow;
import commons.view.entity.EntityResultRow;
import commons.view.entity.results.EntityResult;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by Germain on 04/06/2016.
 */
public abstract class GenerateEntityActionListener<T extends Game> implements ActionListener {

  private final EntityController<T> entityController;
  private final EntityOptionRow<T> entityOptionRow;
  private final EntityResultRow entityResultRow;

  protected GenerateEntityActionListener(EntityController<T> entityController, EntityOptionRow<T> entityOptionRow,
                                         EntityResultRow entityResultRow) {
    this.entityController = entityController;
    this.entityOptionRow = entityOptionRow;
    this.entityResultRow = entityResultRow;
  }

  public void actionPerformed(ActionEvent e) {
    entityResultRow.clearResults();
    try {
      entityResultRow.setResultsToPrint(generateResults(entityOptionRow.getNumberOfEntitiesSelected(), getConstraints()), "|");
    } catch (WrongClassException e1) {
      e1.printStackTrace();
    }
  }

  private GlobalConstraints getConstraints() {
    return entityOptionRow.isConstraintsCheckBoxSelected()
            ? entityController.getGlobalConstraints()
            : new GlobalConstraints();
  }

  private Collection<EntityResult> generateResults(int numberOfItems, GlobalConstraints globalConstraints)
          throws WrongClassException {
    List<EntityResult> results = new ArrayList<>(numberOfItems);
    IntStream.rangeClosed(1, entityOptionRow.getNumberOfEntitiesSelected())
            .forEach(i -> results.add(generateResult(globalConstraints)));
    return results;
  }

  protected abstract EntityResult generateResult(GlobalConstraints globalConstraints);

  protected abstract Entity<T> generate(GlobalConstraints globalConstraints)
          throws NoAvailableEntityTypeException;

}
