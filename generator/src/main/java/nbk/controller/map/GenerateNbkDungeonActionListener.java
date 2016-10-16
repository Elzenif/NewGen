package nbk.controller.map;

import commons.controller.commons.GenerateActionListener;
import commons.model.map.constraints.MapConstraint;
import commons.view.map.MapResultRow;
import nbk.model.map.dungeon.NbkDungeon;
import nbk.model.map.dungeon.constraints.EDungeonDraw;
import nbk.view.map.options.NbkDungeonOptionRow;
import nbk.view.map.results.DungeonResult;

import java.awt.Image;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by Germain on 24/09/2016.
 */
public class GenerateNbkDungeonActionListener extends GenerateActionListener<NbkDungeonOptionRow, MapResultRow,
    DungeonResult, Image, MapConstraint<EDungeonDraw>> {

  public GenerateNbkDungeonActionListener(NbkDungeonOptionRow dungeonOptionRow, MapResultRow mapResultRow,
                                          NbkDungeonController dungeonController) {
    super(dungeonOptionRow, mapResultRow, dungeonController);
  }

  @Override
  protected MapConstraint<EDungeonDraw> newConstraint() {
    return new MapConstraint<>();
  }

  @Override
  protected Collection<DungeonResult> generateResult(MapConstraint<EDungeonDraw> mapConstraint) {
    NbkDungeon dungeon = NbkDungeon.create(mapConstraint);
    DungeonResult dungeonResult = new DungeonResult(dungeon, resultRow.isShowGridCheckBoxSelected(), 1);
    resultRow.setEnabledRowButtons(true);
    resultRow.resetZoomValue();
    return Collections.singleton(dungeonResult);
  }
}
