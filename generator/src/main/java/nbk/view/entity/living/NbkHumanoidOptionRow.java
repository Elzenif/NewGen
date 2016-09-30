package nbk.view.entity.living;

import commons.view.entity.EntityResultRow;
import nbk.controller.entity.living.NbkHumanoidController;
import nbk.model.entity.living.ENbkAvailableLivings;

/**
 * Created by Germain on 28/08/2016.
 */
public class NbkHumanoidOptionRow extends NbkLivingOptionRow {


  NbkHumanoidOptionRow() {
    super(ENbkAvailableLivings.HUMANOID);

    finalizeRowConstruction("Generate a random " + name);
  }

  @Override
  public void setControllers(EntityResultRow resultRow) {
    super.setControllers(new NbkHumanoidController(this, resultRow));
  }
}
