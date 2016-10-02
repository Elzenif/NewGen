package nbk.controller.utility.love;

import commons.controller.utility.UtilityController;
import commons.view.utility.UtilityResultRow;
import nbk.controller.utility.DrawChangeListener;
import nbk.model.utility.love.constraints.ELoveDraw;
import nbk.view.utility.love.LoveOptionRow;

import java.util.Arrays;
import java.util.EnumMap;

/**
 * Created by Germain on 24/07/2016.
 */
public class LoveController extends UtilityController<ELoveDraw> {

  private EnumMap<ELoveDraw, DrawChangeListener<ELoveDraw>> drawChangeListenerMap
      = new EnumMap<>(ELoveDraw.class);

  public LoveController(LoveOptionRow loveOptionRow, UtilityResultRow loveResultRow) {
    super(loveOptionRow);
    generateActionListener = new GenerateLoveActionListener(loveOptionRow, loveResultRow, this);
    Arrays.stream(ELoveDraw.values()).forEach(loveDraw -> {
      drawChangeListenerMap.put(loveDraw, new DrawChangeListener<>(this, loveDraw));
      generationConstraint.put(loveDraw, 1);
    });
  }

  @Override
  public void updateDrawKeyValue(ELoveDraw drawKey) {
    generationConstraint.put(drawKey, ((LoveOptionRow) utilityOptionRow).getDrawValue(drawKey));
  }

  public DrawChangeListener getDrawChangeListener(ELoveDraw loveDraw) {
    return drawChangeListenerMap.get(loveDraw);
  }
}
