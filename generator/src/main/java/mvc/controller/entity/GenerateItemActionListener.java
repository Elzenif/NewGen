package mvc.controller.entity;

import mvc.model.entity.constraints.GlobalConstraints;
import mvc.model.entity.constraints.RarityConstraint;
import mvc.model.entity.game.Game;
import mvc.model.entity.items.Item;
import mvc.model.entity.results.EItemResultRarity;
import mvc.model.entity.results.ItemResult;
import mvc.model.entity.utils.ERarity;
import mvc.model.entity.utils.ItemUtils;
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

  private Collection<ItemResult> generateResults(int numberOfItems, GlobalConstraints globalConstraints) throws WrongClassException {
    List<ItemResult> results = new ArrayList<>(numberOfItems);
    IntStream.rangeClosed(1, entityOptionRow.getNumberOfItemsSelected())
            .forEach(i -> results.add(generateResult(globalConstraints)));
    return results;
  }

  private ItemResult generateResult(GlobalConstraints globalConstraints) {
    ERarity rarity = ItemUtils.selectRandomItemType(ERarity.values(),
            globalConstraints.getPredicate(ERarity.class, RarityConstraint.class));
    Item<T> item = generate(globalConstraints, rarity);
    return new ItemResult(item.toString(), EItemResultRarity.getItemResultRarity(item.getRarity()));
  }

  protected abstract Item<T> generate(GlobalConstraints globalConstraints, ERarity rarity);

}
