package commons.controller.entity.items;

import commons.controller.entity.EntityController;
import commons.model.commons.Game;
import commons.view.entity.items.ItemOptionRow;

/**
 * Created by Germain on 23/10/2016.
 */
public abstract class ItemController<G extends Game> extends EntityController<G> {

  protected ItemController(ItemOptionRow<G> itemOptionRow) {
    super(itemOptionRow);
  }

}
