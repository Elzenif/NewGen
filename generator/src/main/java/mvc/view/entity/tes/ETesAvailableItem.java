package mvc.view.entity.tes;

import mvc.model.entity.game.TesGame;
import mvc.view.entity.EntityOptionRow;
import mvc.view.entity.IAvailableItem;

/**
 * Created by Germain on 11/06/2016.
 */
public enum ETesAvailableItem implements IAvailableItem<TesGame> {
  ;

  @Override
  public String getName() {
    return null;
  }

  @Override
  public EntityOptionRow<TesGame> getEntityOptionRow() {
    return null;
  }

}