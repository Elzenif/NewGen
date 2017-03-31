package nbk.view.entity.living.options;

import commons.model.commons.IDrawKey;
import commons.model.commons.IDrawKeyIntegerValue;
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

import static commons.Constants.resourceBundle;

/**
 * Created by Germain on 28/08/2016.
 */
public class NbkHumanoidOptionRow extends NbkLivingOptionRow {

  private static final int DEFAULT_STAT = 10;
  private final Map<IDrawKey, Pair<JSpinner, SpinnerNumberModel>> statMap = new LinkedHashMap<>(EStat.values().length);

  NbkHumanoidOptionRow() {
    super(ENbkAvailableLivings.HUMANOID);

    initDrawKeyConstraintPanel(statMap, EStat.values(), DEFAULT_STAT, 8, 13);

    finalizeRowConstruction(MessageFormat.format(resourceBundle.getString("tooltip.entity.generate"), name));
  }

  @Override
  public void setControllers(EntityResultRow resultRow) {
    super.setControllers(new NbkHumanoidController(this, resultRow, DEFAULT_STAT));
    statMap.forEach((stat, pair) ->
        pair.getLeft().addChangeListener(((NbkHumanoidController) controller)
            .getDrawChangeListener((IDrawKeyIntegerValue) stat)));
  }

  @Override
  public Integer getDrawValue(IDrawKey stat) {
    return statMap.get(stat).getRight().getNumber().intValue();
  }
}
