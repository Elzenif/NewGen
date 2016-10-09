package nbk.view.entity.living.options;

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

  HUMANOID_ROW(ENbkAvailableLivings.HUMANOID, new NbkHumanoidOptionRow());

  private final IAvailableLiving<NbkGame> living;
  private final EntityOptionRow<NbkGame> entityOptionRow;
  private final EntityResultRow entityResultRow;

  ENbkAvailableLivingsRow(IAvailableLiving<NbkGame> living, EntityOptionRow<NbkGame> entityOptionRow) {
    this.living = living;
    this.entityOptionRow = entityOptionRow;
    this.entityResultRow = new EntityResultRow(this);
  }

  @Override
  public String getName() {
    return living.getName();
  }

  @Override
  public EntityOptionRow<NbkGame> getOptionRow() {
    return entityOptionRow;
  }

  @Override
  public EntityResultRow getResultRow() {
    return entityResultRow;
  }
}
