package commons.view.dungeon;

import commons.view.dungeon.results.DungeonResult;
import commons.view.utils.ResultRow;

/**
 * Created by Germain on 24/09/2016.
 */
public class DungeonResultRow extends ResultRow<DungeonResult> {

  protected DungeonResultRow(EAvailableDungeonRow dungeonType) {
    super(dungeonType.getName());
  }
}
