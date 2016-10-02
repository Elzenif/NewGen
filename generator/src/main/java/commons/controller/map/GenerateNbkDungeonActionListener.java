package commons.controller.map;

import commons.controller.GenerateActionListener;
import commons.model.map.NbkDungeon;
import commons.model.map.constraints.EDungeonDraw;
import commons.model.map.constraints.MapConstraint;
import commons.view.map.MapResultRow;
import commons.view.map.NbkDungeonOptionRow;
import commons.view.map.results.DungeonResult;

import java.awt.Image;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by Germain on 24/09/2016.
 */
public class GenerateNbkDungeonActionListener extends GenerateActionListener<NbkDungeonOptionRow, MapResultRow,
    DungeonResult, Image, MapConstraint<EDungeonDraw>> {

  private DungeonResult dungeonResult;

  public GenerateNbkDungeonActionListener(NbkDungeonOptionRow dungeonOptionRow, MapResultRow dungeonResultRow,
                                          NbkDungeonController dungeonController) {
    super(dungeonOptionRow, dungeonResultRow, dungeonController);
    this.dungeonResult = null;
  }

  @Override
  protected MapConstraint<EDungeonDraw> newConstraint() {
    return new MapConstraint<>();
  }

  @Override
  protected Collection<DungeonResult> generateResult(MapConstraint<EDungeonDraw> mapConstraint) {
    NbkDungeon dungeon = NbkDungeon.create(mapConstraint);
    resultRow.setEnabledSaveButton(true);
    return Collections.singleton(new DungeonResult(dungeon));
  }

  public DungeonResult getDungeonResult() {
    return dungeonResult;
  }
}
