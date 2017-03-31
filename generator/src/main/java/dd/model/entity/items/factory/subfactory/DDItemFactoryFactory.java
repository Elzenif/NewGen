package dd.model.entity.items.factory.subfactory;

import commons.model.entity.utils.EntityUtils;
import commons.utils.exception.NoAvailableEntityTypeException;
import dd.model.entity.items.characteristics.EDDItemPowerRarityKey;
import dd.model.entity.items.factory.subfactory.enums.EDDItemFactoryFactory;
import dd.model.entity.items.treasures.DDTreasure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Germain on 31/10/2016.
 */
public class DDItemFactoryFactory extends DDMultipleRaritiesTreasureSubFactory {

  private static final Logger LOGGER = LoggerFactory.getLogger(DDItemFactoryFactory.class);
  private static final DDItemFactoryFactory INSTANCE = new DDItemFactoryFactory();

  private DDItemFactoryFactory() {
  }

  public static DDItemFactoryFactory getInstance() {
    return INSTANCE;
  }

  @SuppressWarnings("HardCodedStringLiteral")
  @Override
  protected DDTreasure getTreasure(EDDItemPowerRarityKey powerRarityKey) {
    EDDItemFactoryFactory factory;
    try {
      factory = EntityUtils.selectRandomWithCustomRarity(EDDItemFactoryFactory.values(), powerRarityKey);
    } catch (NoAvailableEntityTypeException e) {
      factory = EDDItemFactoryFactory.values()[0];
      LOGGER.error("Error while selecting random factory", e);
    }
    return factory.getFactory().getTreasure(powerRarityKey);
  }
}
