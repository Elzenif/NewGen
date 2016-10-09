package nbk.view.entity.living.options;

import commons.view.entity.EntityResultRow;
import nbk.controller.entity.living.NbkHumanoidController;
import nbk.model.entity.living.ENbkAvailableLivings;

import java.text.MessageFormat;

import static commons.view.utils.Constants.resourceBundle;

/**
 * Created by Germain on 28/08/2016.
 */
public class NbkHumanoidOptionRow extends NbkLivingOptionRow {


  NbkHumanoidOptionRow() {
    super(ENbkAvailableLivings.HUMANOID);

    finalizeRowConstruction(MessageFormat.format(resourceBundle.getString("tooltip.entity.generate"), name));
  }

  @Override
  public void setControllers(EntityResultRow resultRow) {
    super.setControllers(new NbkHumanoidController(this, resultRow));
  }
}
