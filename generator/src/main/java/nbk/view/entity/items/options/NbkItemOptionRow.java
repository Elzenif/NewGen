package nbk.view.entity.items.options;

import commons.model.entity.items.IAvailableItem;
import commons.view.entity.items.ItemOptionRow;
import nbk.controller.entity.items.NbkItemController;
import nbk.model.commons.NbkGame;

/**
 * Created by Germain on 28/08/2016.
 */
public abstract class NbkItemOptionRow extends ItemOptionRow<NbkGame> {

  protected NbkItemOptionRow(IAvailableItem<NbkGame> availableEntity) {
    super(availableEntity, NbkGame.getInstance().getAvailableItems());
  }

  protected void setControllers(NbkItemController entityController) {
    super.setControllers(entityController);
    qualitySpinner.addChangeListener(((NbkItemController) controller).getRarityChangeListener());

  }
}
