package dd.model.entity.items.factory.subfactory;

import commons.model.entity.utils.EntityUtils;
import commons.utils.exception.NoAvailableEntityTypeException;
import dd.model.entity.items.characteristics.EDDItemPowerRarityKey;
import dd.model.entity.items.characteristics.fields.DDMultipleRaritiesItemType;
import dd.model.entity.items.treasures.DDTreasure;
import dd.model.entity.items.treasures.enums.EDDRing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Germain on 31/10/2016.
 */
public class DDRingFactory extends DDMultipleRaritiesTreasureSubFactory {

  private static final Logger LOGGER = LoggerFactory.getLogger(DDRingFactory.class);
  private static final DDRingFactory INSTANCE = new DDRingFactory();

  private DDRingFactory() {
    super();
  }

  public static DDRingFactory getInstance() {
    return INSTANCE;
  }

  @SuppressWarnings("HardCodedStringLiteral")
  @Override
  protected DDTreasure getTreasure(EDDItemPowerRarityKey powerRarityKey) {
    DDMultipleRaritiesItemType item;
    DDMultipleRaritiesItemType[] values = EDDRing.values();
    try {
      item = EntityUtils.selectRandomWithCustomRarity(values, powerRarityKey);
    } catch (NoAvailableEntityTypeException e) {
      item = values[0];
      LOGGER.error("Error while selecting random treasure");
    }
    return new DDTreasure(item.getName(), item.getValue());
  }
}
