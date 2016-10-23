package nbk.controller.utility.love;

import commons.controller.utility.UtilityController;
import commons.view.utility.UtilityResultRow;
import nbk.controller.utility.DrawChangeListener;
import nbk.model.utility.love.constraints.ELoveDraw;
import nbk.view.utility.love.options.LoveOptionRow;

import java.util.Arrays;
import java.util.EnumMap;

/**
 * Created by Germain on 24/07/2016.
 */
public class LoveController extends UtilityController<ELoveDraw> {

  private final EnumMap<ELoveDraw, DrawChangeListener<ELoveDraw>> drawChangeListenerMap
      = new EnumMap<>(ELoveDraw.class);

  public LoveController(LoveOptionRow loveOptionRow, UtilityResultRow loveResultRow, int defaultValue) {
    super(loveOptionRow);
    generateActionListener = new GenerateLoveActionListener(loveOptionRow, loveResultRow, this);
    Arrays.stream(ELoveDraw.values()).forEach(loveDraw -> {
      drawChangeListenerMap.put(loveDraw, new DrawChangeListener<>(this, loveDraw));
      generationConstraint.put(loveDraw, defaultValue);
    });
  }

  @Override
  public void updateDrawKeyValue(ELoveDraw drawKey) {
    generationConstraint.put(drawKey, (Integer) utilityOptionRow.getDrawValue(drawKey));
  }

  public DrawChangeListener<ELoveDraw> getDrawChangeListener(ELoveDraw loveDraw) {
    return drawChangeListenerMap.get(loveDraw);
  }
}
