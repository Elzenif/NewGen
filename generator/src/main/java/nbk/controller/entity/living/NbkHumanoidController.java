package nbk.controller.entity.living;

import commons.controller.entity.EntityController;
import commons.model.entity.characteristics.primary.enums.EItemRarity;
import commons.model.entity.constraints.GenericConstraint;
import commons.view.entity.EntityResultRow;
import nbk.model.commons.NbkGame;
import nbk.view.entity.living.NbkHumanoidOptionRow;

/**
 * Created by Germain on 28/08/2016.
 */
public class NbkHumanoidController extends EntityController<NbkGame> {

  public NbkHumanoidController(NbkHumanoidOptionRow nbkHumanoidOptionRow, EntityResultRow resultRow) {
    super(nbkHumanoidOptionRow);
    generateEntityActionListener = new GenerateNbkHumanoidActionListener(nbkHumanoidOptionRow, resultRow, this);
  }

  @Override
  public void updateRarityConstraint(GenericConstraint<EItemRarity> constraint) {
  }
}
