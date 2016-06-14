package mvc.controller.entity;

import mvc.model.entity.items.*;
import mvc.model.entity.results.*;
import mvc.model.entity.utils.Constraints;
import mvc.view.entity.EntityOptionRow;
import mvc.view.entity.EntityResultRow;
import utils.exception.WrongClassException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by Germain on 04/06/2016.
 */
public abstract class GenerateItemActionListener implements ActionListener {

  private final EntityOptionRow entityOptionRow;
  private final EntityResultRow entityResultRow;

  protected GenerateItemActionListener(EntityOptionRow entityOptionRow, EntityResultRow entityResultRow) {
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

  private Constraints getConstraints() {
    return entityOptionRow.isConstraintsCheckBoxSelected()
            ? entityOptionRow.getConstraints()
            : new Constraints();
  }

  private Collection<ItemResult> generateResults(int numberOfItems, Constraints constraints) throws WrongClassException {
    List<ItemResult> results = new ArrayList<>(numberOfItems);
    IntStream.rangeClosed(1, entityOptionRow.getNumberOfItemsSelected())
            .forEach(i -> results.add(generateResult(constraints)));
    return results;
  }

  private ItemResult generateResult(Constraints constraints) {
    Item item = generate(constraints);
    return new ItemResult(item.toString(), EItemResultRarity.getItemResultRarity(item.getRarity()));
  }

  protected abstract Item generate(Constraints constraints);

}
