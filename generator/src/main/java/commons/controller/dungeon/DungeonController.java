package commons.controller.dungeon;

import commons.controller.AbstractOptionRowController;
import commons.controller.entity.items.ConstraintsItemListener;
import commons.controller.intf.HasDrawKeysController;
import commons.model.dungeon.constraints.DungeonConstraint;
import commons.model.dungeon.constraints.EDungeonDraw;
import commons.view.dungeon.DungeonOptionRow;
import commons.view.dungeon.DungeonResultRow;
import nbk.controller.utility.DrawChangeListener;

import java.util.Arrays;
import java.util.EnumMap;

/**
 * Created by Germain on 26/09/2016.
 */
public class DungeonController extends AbstractOptionRowController<DungeonConstraint<EDungeonDraw>>
    implements HasDrawKeysController<EDungeonDraw> {

  private final SaveDungeonActionListener saveDungeonActionListener;
  private final DungeonOptionRow dungeonOptionRow;

  private final EnumMap<EDungeonDraw, DrawChangeListener<EDungeonDraw>> drawChangeListenerMap
      = new EnumMap<>(EDungeonDraw.class);

  public DungeonController(DungeonOptionRow dungeonOptionRow, DungeonResultRow dungeonResultRow) {
    super(new ConstraintsItemListener(dungeonOptionRow), new DungeonConstraint<>());
    this.dungeonOptionRow = dungeonOptionRow;
    generateActionListener = new GenerateDungeonActionListener(dungeonOptionRow, dungeonResultRow, this);
    saveDungeonActionListener = new SaveDungeonActionListener(this, dungeonOptionRow);
    Arrays.stream(EDungeonDraw.values()).forEach(dungeonDraw -> {
      drawChangeListenerMap.put(dungeonDraw, new DrawChangeListener<>(this, dungeonDraw));
      generationConstraint.put(dungeonDraw, dungeonDraw.getDefaultValue());
    });
  }

  public SaveDungeonActionListener getSaveDungeonActionListener() {
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
