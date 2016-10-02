package commons.controller.map;

import commons.controller.AbstractOptionRowController;
import commons.controller.entity.items.ConstraintsItemListener;
import commons.controller.intf.HasDrawKeysController;
import commons.model.map.constraints.EDungeonDraw;
import commons.model.map.constraints.MapConstraint;
import commons.view.map.MapResultRow;
import commons.view.map.NbkDungeonOptionRow;
import nbk.controller.utility.DrawChangeListener;

import java.util.Arrays;
import java.util.EnumMap;

/**
 * Created by Germain on 26/09/2016.
 */
public class NbkDungeonController extends AbstractOptionRowController<MapConstraint<EDungeonDraw>>
    implements HasDrawKeysController<EDungeonDraw> {

  private final SaveMapActionListener saveDungeonActionListener;
  private final NbkDungeonOptionRow dungeonOptionRow;

  private final EnumMap<EDungeonDraw, DrawChangeListener<EDungeonDraw>> drawChangeListenerMap
      = new EnumMap<>(EDungeonDraw.class);

  public NbkDungeonController(NbkDungeonOptionRow dungeonOptionRow, MapResultRow dungeonResultRow) {
    super(new ConstraintsItemListener(dungeonOptionRow), new MapConstraint<>());
    this.dungeonOptionRow = dungeonOptionRow;
    generateActionListener = new GenerateNbkDungeonActionListener(dungeonOptionRow, dungeonResultRow, this);
    saveDungeonActionListener = new SaveMapActionListener(this, dungeonOptionRow);
    Arrays.stream(EDungeonDraw.values()).forEach(dungeonDraw -> {
      drawChangeListenerMap.put(dungeonDraw, new DrawChangeListener<>(this, dungeonDraw));
      generationConstraint.put(dungeonDraw, dungeonDraw.getDefaultValue());
    });
  }

  public SaveMapActionListener getSaveDungeonActionListener() {
    return saveDungeonActionListener;
  }

  public DrawChangeListener<EDungeonDraw> getDrawChangeListener(EDungeonDraw dungeonDraw) {
    return drawChangeListenerMap.get(dungeonDraw);
  }

  @Override
  public void updateDrawKeyValue(EDungeonDraw drawKey) {
    generationConstraint.put(drawKey, dungeonOptionRow.getDrawValue(drawKey));
  }
}
