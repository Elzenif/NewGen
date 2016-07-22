package commons.controller.entity;

import commons.model.commons.Game;
import commons.model.entity.constraints.GlobalConstraints;
import commons.model.entity.items.Item;
import commons.utils.exception.NoAvailableItemTypeException;
import commons.utils.exception.WrongClassException;
import commons.view.entity.EntityOptionRow;
import commons.view.entity.EntityResultRow;
import commons.view.entity.results.ItemResult;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by Germain on 04/06/2016.
 */
public abstract class GenerateItemActionListener<T extends Game> implements ActionListener {

  private final EntityOptionRow<T> entityOptionRow;
  private final EntityResultRow entityResultRow;

  protected GenerateItemActionListener(EntityOptionRow<T> entityOptionRow, EntityResultRow entityResultRow) {
    this.entityOptionRow = entityOptionRow;
    this.entityResultRow = entityResultRow;
  }

  public void actionPerformed(ActionEvent e) {
    entityResultRow.clearResults();
    try {
      entityResultRow.setResultsToPrint(generateResults(entityOptionRow.getNumberOfItemsSelected(), getConstraints()));
    } catch (WrongClassException e1) {
      e1.printStackTrace();
    }
  }

  private GlobalConstraints getConstraints() {
    return entityOptionRow.isConstraintsCheckBoxSelected()
            ? entityOptionRow.getGlobalConstraints()
            : new GlobalConstraints();
  }

  private Collection<ItemResult> generateResults(int numberOfItems, GlobalConstraints globalConstraints)
          throws WrongClassException {
    List<ItemResult> results = new ArrayList<>(numberOfItems);
    IntStream.rangeClosed(1, entityOptionRow.getNumberOfItemsSelected())
            .forEach(i -> results.add(generateResult(globalConstraints)));
    return results;
  }

  private ItemResult generateResult(GlobalConstraints globalConstraints) {
    try {
      Item<T> item = generate(globalConstraints);
      return new ItemResult(item);
    } catch (NoAvailableItemTypeException e) {
      e.printStackTrace();
      return new ItemResult(Item.stubbedItem());
    }
  }

  protected abstract Item<T> generate(GlobalConstraints globalConstraints)
          throws NoAvailableItemTypeException;

}
