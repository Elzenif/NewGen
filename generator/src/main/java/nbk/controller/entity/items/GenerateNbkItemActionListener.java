package nbk.controller.entity.items;

import commons.controller.entity.GenerateEntityActionListener;
import commons.controller.entity.items.ItemController;
import commons.model.commons.constraints.GenerationConstraints;
import commons.model.entity.items.Item;
import commons.utils.exception.NoAvailableEntityTypeException;
import commons.view.entity.EntityResultRow;
import commons.view.entity.items.ItemOptionRow;
import commons.view.entity.results.item.ItemResult;
import nbk.model.commons.NbkGame;

/**
 * Created by Germain on 28/08/2016.
 */
public abstract class GenerateNbkItemActionListener extends GenerateEntityActionListener<NbkGame> {

  protected GenerateNbkItemActionListener(ItemOptionRow<NbkGame> itemOptionRow, EntityResultRow entityResultRow,
                                          ItemController<NbkGame> itemController) {
    super(itemOptionRow, entityResultRow, itemController);
  }

  @Override
  protected ItemResult generateOneResult(GenerationConstraints generationConstraints) {
    try {
      Item item = generate(generationConstraints);
      return new ItemResult(item);
    } catch (NoAvailableEntityTypeException e) {
      e.printStackTrace();
      return new ItemResult(Item.stubbedItem());
    }
  }

  @Override
  protected abstract Item<NbkGame> generate(GenerationConstraints generationConstraints) throws NoAvailableEntityTypeException;
}
