package nbk.view.entity.options;

import commons.model.entity.IAvailableEntity;
import commons.utils.MathUtils;
import commons.view.entity.EntityOptionRow;
import nbk.model.commons.NbkGame;

import java.util.EnumSet;

/**
 * Created by Germain on 08/06/2016.
 */
public abstract class NbkEntityOptionRow extends EntityOptionRow<NbkGame> {

  protected NbkEntityOptionRow(IAvailableEntity<NbkGame> availableEntity,
                               EnumSet<? extends IAvailableEntity> availableEntities) {
    super(availableEntity, MathUtils.maxLength(availableEntities));
  }
}
