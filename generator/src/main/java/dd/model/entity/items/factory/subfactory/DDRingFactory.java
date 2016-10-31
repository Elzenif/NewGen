package dd.model.entity.items.factory.subfactory;

import dd.model.entity.items.characteristics.EDDItemPowerRarityKey;
import dd.model.entity.items.characteristics.fields.DDMultipleRaritiesItemType;
import dd.model.entity.items.treasures.enums.EDDRing;

/**
 * Created by Germain on 31/10/2016.
 */
public class DDRingFactory extends DDMultipleRaritiesTreasureSubFactory {

  private static final DDRingFactory INSTANCE = new DDRingFactory();

  private DDRingFactory() {
    super();
  }

  public static DDRingFactory getInstance() {
    return INSTANCE;
  }

  @Override
  protected DDMultipleRaritiesItemType[] getValues(EDDItemPowerRarityKey powerRarityKey) {
    return EDDRing.values();
  }
}
