package commons.view.dungeon;

import commons.model.dungeon.EDungeonType;
import commons.view.utils.IAvailableRow;

/**
 * Created by Germain on 24/09/2016.
 */
public enum EAvailableDungeonRow implements IAvailableRow<DungeonOptionRow, DungeonResultRow> {

  SIMPLE_DUNGEON(EDungeonType.SIMPLE_DUNGEON) {
    DungeonOptionRow dungeonOptionRow = null;

    @Override
    public DungeonOptionRow getOptionRow() {
      if (dungeonOptionRow == null) {
        dungeonOptionRow = new DungeonOptionRow(EDungeonType.SIMPLE_DUNGEON);
      }
      return dungeonOptionRow;
    }
  };


  private final EDungeonType dungeonType;
  private DungeonResultRow dungeonResultRow;

  EAvailableDungeonRow(EDungeonType dungeonType) {
    this.dungeonType = dungeonType;
  }

  @Override
  public String getName() {
    return dungeonType.getName();
  }

  @Override
  public DungeonResultRow getResultRow() {
    if (dungeonResultRow == null) {
      dungeonResultRow = new DungeonResultRow(this);
    }
    return dungeonResultRow;
  }

}
