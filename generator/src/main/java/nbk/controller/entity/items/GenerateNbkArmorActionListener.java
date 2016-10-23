package nbk.controller.entity.items;

import commons.model.entity.constraints.GlobalConstraints;
import commons.utils.exception.NoAvailableEntityTypeException;
import commons.view.entity.EntityResultRow;
import nbk.model.entity.items.NbkPredefinedArmor;
import nbk.view.entity.items.options.NbkArmorOptionRow;
import org.jetbrains.annotations.Contract;

/**
 * Created by Germain on 26/06/2016.
 */
public class GenerateNbkArmorActionListener extends GenerateNbkItemActionListener {

  public GenerateNbkArmorActionListener(NbkArmorOptionRow armorOptionRow, EntityResultRow entityResultRow,
                                        NbkArmorController armorController) {
    super(armorOptionRow, entityResultRow, armorController);
  }

  @Contract("_ -> !null")
  @Override
  protected NbkPredefinedArmor generate(GlobalConstraints globalConstraints) throws NoAvailableEntityTypeException {
    return NbkPredefinedArmor.create(globalConstraints);
  }
}
