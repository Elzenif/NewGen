package commons.controller.map;

import commons.view.map.MapResultRow;
import nbk.view.map.results.DungeonResult;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.Collections;

/**
 * Created by Germain on 16/10/2016.
 */
public class ZoomChangeListener implements ChangeListener {

  private static final int MAX_ZOOM = 2;

  private final MapResultRow mapResultRow;

  public ZoomChangeListener(MapResultRow mapResultRow) {
    this.mapResultRow = mapResultRow;
  }

  @Override
  public void stateChanged(ChangeEvent e) {
    mapResultRow.clearResults();
    DungeonResult dungeonResult = mapResultRow.getResult();

    double scale = convert(mapResultRow.getZoomValue());
    dungeonResult.setScale(scale);
    mapResultRow.setResultsToPrint(Collections.singletonList(dungeonResult));
  }

  private double convert(int zoomValue) {
    return Math.exp(zoomValue * Math.log(MAX_ZOOM) / MapResultRow.MAX_ZOOM_SLIDER_VALUE);
  }
}
