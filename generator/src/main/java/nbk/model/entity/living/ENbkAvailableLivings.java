package nbk.model.entity.living;

import commons.model.entity.living.IAvailableLiving;
import commons.utils.StringUtils;
import nbk.model.commons.NbkGame;

/**
 * Created by Germain on 28/08/2016.
 */
public enum ENbkAvailableLivings implements IAvailableLiving<NbkGame> {
  HUMANOID;

  @Override
  public String getName() {
    return StringUtils.capitalizeFirstLetter(toString(), true);
  }
}
