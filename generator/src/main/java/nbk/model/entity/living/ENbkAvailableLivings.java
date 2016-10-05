package nbk.model.entity.living;

import commons.model.entity.living.IAvailableLiving;
import nbk.model.commons.NbkGame;

import static commons.view.utils.Constants.resourceBundle;

/**
 * Created by Germain on 28/08/2016.
 */
public enum ENbkAvailableLivings implements IAvailableLiving<NbkGame> {
  HUMANOID(resourceBundle.getString("row.living"));

  private final String name;

  ENbkAvailableLivings(String name) {
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }
}
