package commons.controller.map;

import commons.controller.GenerateActionListener;
import commons.model.map.Dungeon;
import commons.model.map.constraints.DungeonConstraint;
import commons.model.map.constraints.EDungeonDraw;
import commons.view.map.DungeonOptionRow;
import commons.view.map.DungeonResultRow;
import commons.view.map.results.DungeonResult;

import java.awt.Image;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by Germain on 24/09/2016.
 */
public class GenerateDungeonActionListener extends GenerateActionListener<DungeonOptionRow, DungeonResultRow,
    DungeonResult, Image, DungeonConstraint<EDungeonDraw>> {

  private DungeonResult dungeonResult;

  public GenerateDungeonActionListener(DungeonOptionRow dungeonOptionRow, DungeonResultRow dungeonResultRow,
                                       DungeonController dungeonController) {
    super(dungeonOptionRow, dungeonResultRow, dungeonController);
    this.dungeonResult = null;
  }

  @Override
  protected DungeonConstraint<EDungeonDraw> newConstraint() {
    return new DungeonConstraint<>();
  }

  @Override
  protected Collection<DungeonResult> generateResult(DungeonConstraint<EDungeonDraw> dungeonConstraint) {
    Dungeon dungeon = Dungeon.create(dungeonConstraint);
    resultRow.setEnabledSaveButton(true);
    return Collections.singleton(new DungeonResult(dungeon));
  }

  public DungeonResult getDungeonResult() {
    return dungeonResult;
  }
}
