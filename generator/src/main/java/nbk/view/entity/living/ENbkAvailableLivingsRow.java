package nbk.view.entity.living;

import commons.model.entity.living.IAvailableLiving;
import commons.view.entity.EntityOptionRow;
import commons.view.entity.EntityResultRow;
import commons.view.entity.IAvailableEntityRow;
import nbk.model.commons.NbkGame;
import nbk.model.entity.living.ENbkAvailableLivings;

/**
 * Created by Germain on 28/08/2016.
 */
public enum ENbkAvailableLivingsRow implements IAvailableEntityRow<NbkGame> {

  HUMANOID_ROW(ENbkAvailableLivings.HUMANOID) {
    NbkHumanoidOptionRow nbkHumanoidOptionRow = null;
    @Override
    public EntityOptionRow<NbkGame> getOptionRow() {
      if (nbkHumanoidOptionRow == null)
        nbkHumanoidOptionRow = new NbkHumanoidOptionRow();
      return nbkHumanoidOptionRow;
    }
  };

  private final IAvailableLiving<NbkGame> living;
  private EntityResultRow entityResultRow;

  ENbkAvailableLivingsRow(IAvailableLiving<NbkGame> living) {
    this.living = living;
  }

  @Override
  public String getName() {
    return living.getName();
  }

  @Override
  public EntityResultRow getResultRow() {
    if (entityResultRow == null)
      entityResultRow = new EntityResultRow(this);
    return entityResultRow;
  }
}
