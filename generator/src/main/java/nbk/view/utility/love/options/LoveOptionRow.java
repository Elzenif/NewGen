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

  private final Map<ELoveDraw, Pair<JSpinner, SpinnerNumberModel>> loveDrawMap;

  public LoveOptionRow() {
    super(ENbkAvailableUtility.LOVE_ROLEPLAY.getName());

    loveDrawMap = new LinkedHashMap<>(ELoveDraw.values().length);
    for (ELoveDraw loveDraw : ELoveDraw.values()) {
      SpinnerNumberModel spinnerNumberModel = new SpinnerNumberModel(1, 1, 20, 1);
      JSpinner jSpinner = new JSpinner(spinnerNumberModel);
      jSpinner.setAlignmentX(LEFT_ALIGNMENT);
      loveDrawMap.put(loveDraw, new Pair<>(jSpinner, spinnerNumberModel));
      constraintPanel.add(jSpinner);
    }

    finalizeRowConstruction(resourceBundle.getString("tooltip.love.generate"));
  }

  @Override
  public void setControllers(UtilityResultRow resultRow) {
    super.setControllers(new LoveController(this, resultRow));
    loveDrawMap.forEach((loveDraw, pair) ->
        pair.getLeft().addChangeListener(((LoveController) controller).getDrawChangeListener(loveDraw)));
  }

  @Override
  public Object getDrawValue(ELoveDraw drawKey) {
    return loveDrawMap.get(drawKey).getRight().getNumber().intValue();
  }
}
