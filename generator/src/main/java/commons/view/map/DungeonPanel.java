package commons.view.map;

import commons.view.utils.DoublePanel;

/**
 * Created by Germain on 24/09/2016.
 */
public class DungeonPanel extends DoublePanel<DungeonOptionRow, DungeonResultRow> {

  public DungeonPanel() {
    super(EAvailableDungeonRow.values());
  }
}
