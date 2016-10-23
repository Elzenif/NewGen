package nbk.controller.map;

import commons.controller.commons.GenerateActionListener;
import commons.model.commons.constraints.GenerationConstraints;
import commons.view.map.MapResultRow;
import nbk.model.map.dungeon.NbkDungeon;
import nbk.view.map.options.NbkDungeonOptionRow;
import nbk.view.map.results.DungeonResult;

import java.awt.Image;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by Germain on 24/09/2016.
 */
public class GenerateNbkDungeonActionListener extends GenerateActionListener<NbkDungeonOptionRow, MapResultRow,
    DungeonResult, Image> {

  public GenerateNbkDungeonActionListener(NbkDungeonOptionRow dungeonOptionRow, MapResultRow mapResultRow,
                                          NbkDungeonController dungeonController) {
    super(dungeonOptionRow, mapResultRow, dungeonController);
  }

  @Override
  protected Collection<DungeonResult> generateResult(GenerationConstraints generationConstraints) {
    NbkDungeon dungeon = NbkDungeon.create(generationConstraints.getMapConstraint());
    DungeonResult dungeonResult = new DungeonResult(dungeon, resultRow.isShowGridCheckBoxSelected());
    resultRow.setEnabledRowButtons(true);
    resultRow.resetZoomValue();
    return Collections.singleton(dungeonResult);
  }
}
