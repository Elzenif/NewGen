package nbk.controller.entity.living;

import commons.controller.entity.living.LivingController;
import commons.controller.intf.HasDrawKeysController;
import commons.model.commons.IDrawKeyIntegerValue;
import commons.view.entity.EntityResultRow;
import nbk.controller.utility.DrawChangeListener;
import nbk.model.commons.NbkGame;
import nbk.model.entity.living.characteristics.primary.EStat;
import nbk.view.entity.living.options.NbkHumanoidOptionRow;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Germain on 28/08/2016.
 */
public class NbkHumanoidController extends LivingController<NbkGame>
    implements HasDrawKeysController<IDrawKeyIntegerValue> {

  private final Map<IDrawKeyIntegerValue, DrawChangeListener<IDrawKeyIntegerValue>> drawChangeListenerMap
      = new LinkedHashMap<>(EStat.values().length);

  public NbkHumanoidController(NbkHumanoidOptionRow nbkHumanoidOptionRow, EntityResultRow resultRow,
                               Integer defaultValue) {
    super(nbkHumanoidOptionRow);
    generateActionListener = new GenerateNbkHumanoidActionListener(nbkHumanoidOptionRow, resultRow, this);
    Arrays.stream(EStat.values()).forEach(stat -> {
      drawChangeListenerMap.put(stat, new DrawChangeListener<>(this, stat));
      generationConstraints.getDrawKeyConstraint().put(stat, defaultValue);
    });
  }

  public DrawChangeListener getDrawChangeListener(IDrawKeyIntegerValue stat) {
    return drawChangeListenerMap.get(stat);
  }

  @Override
  public void updateDrawKeyValue(IDrawKeyIntegerValue stat) {
    generationConstraints.getDrawKeyConstraint().put(stat, (Integer) livingOptionRow.getDrawValue(stat));
  }
}
