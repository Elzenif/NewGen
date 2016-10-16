package commons.controller.map;

import commons.view.map.MapResultRow;
import nbk.view.map.results.DungeonResult;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Collections;

/**
 * Created by Germain on 02/10/2016.
 */
public class ShowGridItemListener implements ItemListener {

  private final MapResultRow mapResultRow;

  public ShowGridItemListener(MapResultRow mapResultRow) {
    this.mapResultRow = mapResultRow;
  }

  @Override
  public void itemStateChanged(ItemEvent e) {
    mapResultRow.clearResults();
    DungeonResult dungeonResult = mapResultRow.getResult();
    dungeonResult.setShowGrid(mapResultRow.isShowGridCheckBoxSelected());
    mapResultRow.setResultsToPrint(Collections.singletonList(dungeonResult));
  }
}
