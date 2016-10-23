package nbk.view.entity.living.options;

import commons.model.commons.constraints.DrawKeyConstraint;
import commons.model.entity.living.IAvailableLiving;
import commons.view.entity.EntityResultRow;
import commons.view.entity.IAvailableEntityRow;
import nbk.model.commons.NbkGame;
import nbk.model.entity.living.ENbkAvailableLivings;

/**
 * Created by Germain on 28/08/2016.
 */
public enum ENbkAvailableLivingsRow implements IAvailableEntityRow<NbkGame, DrawKeyConstraint> {

  HUMANOID_ROW(ENbkAvailableLivings.HUMANOID, new NbkHumanoidOptionRow());

  private final IAvailableLiving<NbkGame> living;
  private final NbkLivingOptionRow livingOptionRow;
  private final EntityResultRow entityResultRow;

  ENbkAvailableLivingsRow(IAvailableLiving<NbkGame> living, NbkLivingOptionRow livingOptionRow) {
    this.living = living;
    this.livingOptionRow = livingOptionRow;
    this.entityResultRow = new EntityResultRow(this);
  }

  @Override
  public String getName() {
    return living.getName();
  }

  @Override
  public NbkLivingOptionRow getOptionRow() {
    return livingOptionRow;
  }

  @Override
  public EntityResultRow getResultRow() {
    return entityResultRow;
  }
}
