package commons.view.map;

import commons.model.map.EMapType;
import commons.view.utils.IAvailableRow;
import nbk.view.map.NbkDungeonOptionRow;

/**
 * Created by Germain on 24/09/2016.
 */
public enum EAvailableMapRow implements IAvailableRow<NbkDungeonOptionRow, MapResultRow> {

  SIMPLE_DUNGEON(EMapType.SIMPLE_DUNGEON) {
    NbkDungeonOptionRow dungeonOptionRow = null;

    @Override
    public NbkDungeonOptionRow getOptionRow() {
      if (dungeonOptionRow == null) {
        dungeonOptionRow = new NbkDungeonOptionRow(EMapType.SIMPLE_DUNGEON);
      }
      return dungeonOptionRow;
    }
  };


  private final EMapType dungeonType;
  private MapResultRow dungeonResultRow;

  EAvailableMapRow(EMapType dungeonType) {
    this.dungeonType = dungeonType;
  }

  @Override
  public String getName() {
    return dungeonType.getName();
  }

  @Override
  public MapResultRow getResultRow() {
    if (dungeonResultRow == null) {
      dungeonResultRow = new MapResultRow();
    }
    return dungeonResultRow;
  }

}
