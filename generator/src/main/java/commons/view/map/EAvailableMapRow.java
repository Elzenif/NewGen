package commons.view.map;

import commons.model.map.EMapType;
import commons.view.commons.IAvailableRow;
import nbk.view.map.options.NbkDungeonOptionRow;

/**
 * Created by Germain on 24/09/2016.
 */
public enum EAvailableMapRow implements IAvailableRow<NbkDungeonOptionRow, MapResultRow> {

  SIMPLE_DUNGEON(EMapType.SIMPLE_DUNGEON, new NbkDungeonOptionRow(EMapType.SIMPLE_DUNGEON));

  private static final MapResultRow DUNGEON_RESULT_ROW = new MapResultRow();
  private final EMapType dungeonType;
  private final NbkDungeonOptionRow dungeonOptionRow;

  EAvailableMapRow(EMapType dungeonType, NbkDungeonOptionRow dungeonOptionRow) {
    this.dungeonType = dungeonType;
    this.dungeonOptionRow = dungeonOptionRow;
  }

  @Override
  public String getName() {
    return dungeonType.getName();
  }

  @Override
  public NbkDungeonOptionRow getOptionRow() {
    return dungeonOptionRow;
  }

  @Override
  public MapResultRow getResultRow() {
    return DUNGEON_RESULT_ROW;
  }
}
