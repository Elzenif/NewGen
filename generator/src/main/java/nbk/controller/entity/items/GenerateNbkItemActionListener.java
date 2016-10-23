package nbk.controller.entity.items;

import commons.controller.entity.GenerateEntityActionListener;
import commons.controller.entity.items.ItemController;
import commons.model.entity.constraints.GlobalConstraints;
import commons.model.entity.items.Item;
import commons.utils.exception.NoAvailableEntityTypeException;
import commons.view.entity.EntityResultRow;
import commons.view.entity.items.ItemOptionRow;
import commons.view.entity.results.item.ItemResult;
import nbk.model.commons.NbkGame;

/**
 * Created by Germain on 28/08/2016.
 */
public abstract class GenerateNbkItemActionListener extends GenerateEntityActionListener<NbkGame, GlobalConstraints> {

  protected GenerateNbkItemActionListener(ItemOptionRow<NbkGame> itemOptionRow, EntityResultRow entityResultRow,
                                          ItemController<NbkGame> itemController) {
    super(itemOptionRow, entityResultRow, itemController);
  }

  @Override
  protected GlobalConstraints newConstraint() {
    return new GlobalConstraints();
  }

  @Override
  protected ItemResult generateOneResult(GlobalConstraints globalConstraints) {
    try {
      Item item = generate(globalConstraints);
      return new ItemResult(item);
    } catch (NoAvailableEntityTypeException e) {
      e.printStackTrace();
      return new ItemResult(Item.stubbedItem());
    }
  }

  @Override
  protected abstract Item<NbkGame> generate(GlobalConstraints globalConstraints) throws NoAvailableEntityTypeException;
}
