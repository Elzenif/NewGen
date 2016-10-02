package commons.view.map;

import commons.view.utils.DoublePanel;
import nbk.view.map.NbkDungeonOptionRow;

/**
 * Created by Germain on 24/09/2016.
 */
public class MapPanel extends DoublePanel<NbkDungeonOptionRow, MapResultRow> {

  public MapPanel() {
    super(EAvailableMapRow.values());
  }
}
