package nbk.view.entity.living.options;

import commons.utils.Pair;
import commons.view.entity.EntityResultRow;
import nbk.controller.entity.living.NbkHumanoidController;
import nbk.model.entity.living.ENbkAvailableLivings;
import nbk.model.entity.living.characteristics.primary.EStat;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.text.MessageFormat;
import java.util.LinkedHashMap;
import java.util.Map;

import static commons.view.utils.Constants.resourceBundle;

/**
 * Created by Germain on 28/08/2016.
 */
public class NbkHumanoidOptionRow extends NbkLivingOptionRow<EStat> {

  private final Map<EStat, Pair<JSpinner, SpinnerNumberModel>> statMap = new LinkedHashMap<>(EStat.values().length);
  private final int defaultValue = 10;

  NbkHumanoidOptionRow() {
    super(ENbkAvailableLivings.HUMANOID);

    initDrawKeyConstraintPanel(statMap, EStat.values(), defaultValue, 8, 13);

    finalizeRowConstruction(MessageFormat.format(resourceBundle.getString("tooltip.entity.generate"), name));
  }

  @Override
  public void setControllers(EntityResultRow resultRow) {
    super.setControllers(new NbkHumanoidController(this, resultRow, defaultValue));
    statMap.forEach((stat, pair) ->
        pair.getLeft().addChangeListener(((NbkHumanoidController) controller).getDrawChangeListener(stat)));
  }

  @Override
  public Integer getDrawValue(EStat stat) {
    return statMap.get(stat).getRight().getNumber().intValue();
  }
}
