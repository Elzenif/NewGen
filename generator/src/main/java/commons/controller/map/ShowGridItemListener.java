package commons.controller.map;

import commons.view.map.MapResultRow;
import nbk.controller.map.GenerateNbkDungeonActionListener;
import nbk.controller.map.NbkDungeonController;
import nbk.view.map.results.DungeonResult;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Collections;

/**
 * Created by Germain on 02/10/2016.
 */
public class ShowGridItemListener implements ItemListener {

  private final NbkDungeonController dungeonController;
  private final MapResultRow mapResultRow;

  public ShowGridItemListener(NbkDungeonController dungeonController, MapResultRow mapResultRow) {
    this.dungeonController = dungeonController;
    this.mapResultRow = mapResultRow;
  }

  @Override
  public void itemStateChanged(ItemEvent e) {
    mapResultRow.clearResults();
    DungeonResult dungeonResult = ((GenerateNbkDungeonActionListener) dungeonController.getGenerateActionListener())
        .getDungeonResult();
    dungeonResult.setShowGrid(mapResultRow.isShowGridCheckBoxSelected());
    mapResultRow.setResultsToPrint(Collections.singletonList(dungeonResult));
  }
}
