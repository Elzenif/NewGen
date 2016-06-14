package mvc.controller.entity.nbk;

import mvc.controller.entity.*;
import mvc.model.entity.items.*;
import mvc.model.entity.utils.*;
import mvc.view.entity.*;
import mvc.view.entity.nbk.*;

/**
 * Created by Germain on 14/06/2016.
 */
public class GenerateNbkWeaponActionListener extends GenerateItemActionListener {

  public GenerateNbkWeaponActionListener(NbkWeaponOptionRow entityOptionRow, EntityResultRow entityResultRow) {
    super(entityOptionRow, entityResultRow);
  }

  @Override
  protected Item generate(Constraints constraints) {
    return NbkWeapon.create(constraints);
  }
}
