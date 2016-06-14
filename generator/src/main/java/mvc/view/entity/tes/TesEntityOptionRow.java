package mvc.view.entity.tes;

import mvc.model.entity.game.*;
import mvc.view.entity.*;

/**
 * Created by Germain on 09/06/2016.
 */
public class TesEntityOptionRow extends EntityOptionRow<TesGame> {

  TesEntityOptionRow(ETesAvailableItem availableItem) {
    super(availableItem, TesGame.getInstance());
  }

  @Override
  public void updateConstraintsAbility(boolean checkBoxSelected) {

  }
}
