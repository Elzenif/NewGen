package nbk.controller.utility.love;

import commons.controller.utility.UtilityController;
import commons.model.commons.IDrawKey;
import commons.view.utility.UtilityResultRow;
import nbk.controller.utility.DrawChangeListener;
import nbk.model.utility.love.constraints.ELoveDraw;
import nbk.view.utility.love.options.LoveOptionRow;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Germain on 24/07/2016.
 */
public class LoveController extends UtilityController {

  private final Map<IDrawKey, DrawChangeListener> drawChangeListenerMap
      = new LinkedHashMap<>(ELoveDraw.values().length);

  public LoveController(LoveOptionRow loveOptionRow, UtilityResultRow loveResultRow, int defaultValue) {
    super(loveOptionRow);
    generateActionListener = new GenerateLoveActionListener(loveOptionRow, loveResultRow, this);
    Arrays.stream(ELoveDraw.values()).forEach(loveDraw -> {
      drawChangeListenerMap.put(loveDraw, new DrawChangeListener(this, loveDraw));
      generationConstraints.getDrawKeyConstraint().put(loveDraw, defaultValue);
    });
  }

  @Override
  public void updateDrawKeyValue(IDrawKey drawKey) {
    generationConstraints.getDrawKeyConstraint().put(drawKey, (Integer) utilityOptionRow.getDrawValue(drawKey));
  }

  @Override
  public DrawChangeListener getDrawChangeListener(IDrawKey loveDraw) {
    return drawChangeListenerMap.get(loveDraw);
  }
}
