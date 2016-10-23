package nbk.view.utility.love.options;

import commons.utils.Pair;
import commons.view.utility.UtilityResultRow;
import nbk.controller.utility.love.LoveController;
import nbk.model.utility.ENbkAvailableUtility;
import nbk.model.utility.love.constraints.ELoveDraw;
import nbk.view.utility.options.NbkUtilityOptionRow;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.util.LinkedHashMap;
import java.util.Map;

import static commons.view.utils.Constants.resourceBundle;

/**
 * Created by Germain on 24/07/2016.
 */
public class LoveOptionRow extends NbkUtilityOptionRow<ELoveDraw> {

  private final Map<ELoveDraw, Pair<JSpinner, SpinnerNumberModel>> loveDrawMap
      = new LinkedHashMap<>(ELoveDraw.values().length);
  private final int defaultValue = 10;

  public LoveOptionRow() {
    super(ENbkAvailableUtility.LOVE_ROLEPLAY.getName());

    initDrawKeyConstraintPanel(loveDrawMap, ELoveDraw.values(), defaultValue, 1, 20);

    finalizeRowConstruction(resourceBundle.getString("tooltip.love.generate"));
  }

  @Override
  public void setControllers(UtilityResultRow resultRow) {
    super.setControllers(new LoveController(this, resultRow, defaultValue));
    loveDrawMap.forEach((loveDraw, pair) ->
        pair.getLeft().addChangeListener(((LoveController) controller).getDrawChangeListener(loveDraw)));
  }

  @Override
  public Integer getDrawValue(ELoveDraw drawKey) {
    return loveDrawMap.get(drawKey).getRight().getNumber().intValue();
  }
}
