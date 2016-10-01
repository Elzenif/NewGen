package commons.controller.dungeon;

import commons.controller.entity.items.ConstraintsItemListener;
import commons.controller.intf.ConstraintOptionRowController;
import commons.view.dungeon.DungeonOptionRow;
import commons.view.dungeon.DungeonResultRow;

/**
 * Created by Germain on 26/09/2016.
 */
public class DungeonController implements ConstraintOptionRowController {

  private final ConstraintsItemListener constraintsItemListener;
  private final GenerateDungeonActionListener generateDungeonActionListener;
  private final SaveDungeonActionListener saveDungeonActionListener;

  public DungeonController(DungeonOptionRow dungeonOptionRow, DungeonResultRow dungeonResultRow) {
    constraintsItemListener = new ConstraintsItemListener(dungeonOptionRow);
    generateDungeonActionListener = new GenerateDungeonActionListener(dungeonOptionRow, dungeonResultRow);
    saveDungeonActionListener = new SaveDungeonActionListener(this, dungeonOptionRow);
  }

  @Override
  public ConstraintsItemListener getConstraintsItemListener() {
    return constraintsItemListener;
  }

  public GenerateDungeonActionListener getGenerateDungeonActionListener() {
    return generateDungeonActionListener;
  }

  public SaveDungeonActionListener getSaveDungeonActionListener() {
    return saveDungeonActionListener;
  }
}
