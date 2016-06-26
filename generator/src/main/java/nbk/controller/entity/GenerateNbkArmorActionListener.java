package nbk.controller.entity;

import commons.controller.entity.GenerateItemActionListener;
import commons.model.entity.constraints.GlobalConstraints;
import commons.model.entity.enums.ERarity;
import commons.utils.exception.NoAvailableItemTypeException;
import commons.view.entity.EntityResultRow;
import nbk.model.entity.game.NbkGame;
import nbk.model.entity.items.NbkPredefinedArmor;
import nbk.view.entity.NbkArmorOptionRow;
import org.jetbrains.annotations.Contract;

/**
 * Created by Germain on 26/06/2016.
 */
public class GenerateNbkArmorActionListener extends GenerateItemActionListener<NbkGame> {

  public GenerateNbkArmorActionListener(NbkArmorOptionRow entityOptionRow, EntityResultRow entityResultRow) {
    super(entityOptionRow, entityResultRow);
  }

  @Contract("_, _ -> !null")
  @Override
  protected NbkPredefinedArmor generate(GlobalConstraints globalConstraints, ERarity rarity) throws NoAvailableItemTypeException {
    return NbkPredefinedArmor.create(globalConstraints, rarity);
  }
}
