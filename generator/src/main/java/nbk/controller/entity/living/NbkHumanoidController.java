package nbk.controller.entity.living;

import commons.controller.entity.living.LivingController;
import commons.controller.intf.HasDrawKeysController;
import commons.model.utility.constraints.DrawKeyConstraint;
import commons.view.entity.EntityResultRow;
import nbk.controller.utility.DrawChangeListener;
import nbk.model.commons.NbkGame;
import nbk.model.entity.living.characteristics.primary.EStat;
import nbk.view.entity.living.options.NbkHumanoidOptionRow;

import java.util.Arrays;
import java.util.EnumMap;

/**
 * Created by Germain on 28/08/2016.
 */
public class NbkHumanoidController extends LivingController<NbkGame, EStat>
    implements HasDrawKeysController<EStat> {

  private final EnumMap<EStat, DrawChangeListener<EStat>> drawChangeListenerMap = new EnumMap<>(EStat.class);

  public NbkHumanoidController(NbkHumanoidOptionRow nbkHumanoidOptionRow, EntityResultRow resultRow, Integer defaultValue) {
    super(nbkHumanoidOptionRow, new DrawKeyConstraint());
    generateActionListener = new GenerateNbkHumanoidActionListener(nbkHumanoidOptionRow, resultRow, this);
    Arrays.stream(EStat.values()).forEach(stat -> {
      drawChangeListenerMap.put(stat, new DrawChangeListener<>(this, stat));
      generationConstraint.put(stat, defaultValue);
    });
  }

  public DrawChangeListener<EStat> getDrawChangeListener(EStat stat) {
    return drawChangeListenerMap.get(stat);
  }

  @Override
  public void updateDrawKeyValue(EStat stat) {
    generationConstraint.put(stat, (Integer) livingOptionRow.getDrawValue(stat));
  }
}
