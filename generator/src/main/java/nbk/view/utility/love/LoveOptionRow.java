package nbk.view.utility.love;

import commons.view.utility.UtilityResultRow;
import nbk.controller.utility.love.LoveController;
import nbk.model.utility.ENbkAvailableUtility;
import nbk.model.utility.love.ELoveDraw;
import nbk.view.utility.NbkUtilityOptionRow;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Germain on 24/07/2016.
 */
public class LoveOptionRow extends NbkUtilityOptionRow<ELoveDraw> {

  private final Map<ELoveDraw, SpinnerNumberModel> loveDrawMap;

  public LoveOptionRow() {
    super(ENbkAvailableUtility.LOVE_ROLEPLAY.getName());

    loveDrawMap = new LinkedHashMap<>(ELoveDraw.values().length);
    for (ELoveDraw loveDraw : ELoveDraw.values()) {
      SpinnerNumberModel spinnerNumberModel = new SpinnerNumberModel(1, 1, 20, 1);
      JSpinner jSpinner = new JSpinner(spinnerNumberModel);
      jSpinner.setAlignmentX(LEFT_ALIGNMENT);
      loveDrawMap.put(loveDraw, spinnerNumberModel);
      constraintPanel.add(jSpinner);
    }

    finalizeRowConstruction("Attempt to make love");
  }

  @Override
  public void setControllers(UtilityResultRow resultRow) {
    super.setControllers(new LoveController(this, resultRow));
    generateButton.addActionListener(((LoveController) controller).getMakeLoveActionListener());
  }

  public int getLoveDrawDiceScore(ELoveDraw loveDraw) {
    return loveDrawMap.get(loveDraw).getNumber().intValue();
  }

  @Override
  public int getDrawValue(ELoveDraw drawKey) {
    return 0;
  }
}
