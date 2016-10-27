package dd.model.entity.items.treasure;

import commons.model.commons.IDrawKeyIntegerValue;

/**
 * Created by Germain on 26/10/2016.
 */
public enum EDDTreasureDraw implements IDrawKeyIntegerValue {
  DICE {
    @Override
    public int getMaxValue() {
      return 100;
    }
  }, LEVEL {
    @Override
    public int getMaxValue() {
      return DDTreasure.LEVEL_MAX;
    }
  }

}
