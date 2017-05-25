package commons.view.map;

import commons.view.GameMainFrame;
import commons.view.commons.DoublePanel;
import nbk.view.map.options.NbkDungeonOptionRow;

/**
 * Created by Germain on 24/09/2016.
 */
public class MapPanel extends DoublePanel<NbkDungeonOptionRow, MapResultRow, GameMainFrame> {

  public MapPanel() {
    super(EAvailableMapRow.values());
  }
}
