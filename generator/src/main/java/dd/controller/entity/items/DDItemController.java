package dd.controller.entity.items;

import commons.controller.entity.items.ItemController;
import dd.model.commons.DDGame;
import dd.model.entity.items.treasure.EDDTreasureDraw;
import dd.view.entity.items.options.DDItemOptionRow;

/**
 * Created by Germain on 27/10/2016.
 */
public abstract class DDItemController extends ItemController<DDGame> {

  private final DDRarityChangeListener rarityChangeListener;
  private final DDLevelChangeListener levelChangeListener;

  protected DDItemController(DDItemOptionRow itemOptionRow) {
    super(itemOptionRow);
    rarityChangeListener = new DDRarityChangeListener(itemOptionRow, this);
    levelChangeListener = new DDLevelChangeListener(itemOptionRow, this);
  }

  @Override
  public DDRarityChangeListener getRarityChangeListener() {
    return rarityChangeListener;
  }

  public DDLevelChangeListener getLevelChangeListener() {
    return levelChangeListener;
  }

  public void updateRarityConstraint(int rarityLevel) {
    generationConstraints.getDrawKeyConstraint().put(EDDTreasureDraw.DICE, rarityLevel);
  }

  public void updateLevelConstraint(int level) {
    generationConstraints.getDrawKeyConstraint().put(EDDTreasureDraw.LEVEL, level);
  }
}
