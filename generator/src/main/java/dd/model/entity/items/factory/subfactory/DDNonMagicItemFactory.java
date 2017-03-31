package dd.model.entity.items.factory.subfactory;

import commons.model.entity.utils.EntityUtils;
import commons.utils.exception.NoAvailableEntityTypeException;
import dd.model.entity.items.characteristics.fields.DDOneRarityItemType;
import dd.model.entity.items.factory.subfactory.enums.EDDNonMagicItemFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Germain on 30/10/2016.
 */
public class DDNonMagicItemFactory extends DDOneRarityTreasureSubFactory {

  private static final Logger LOGGER = LoggerFactory.getLogger(DDNonMagicItemFactory.class);
  private static final DDNonMagicItemFactory INSTANCE = new DDNonMagicItemFactory();

  private DDNonMagicItemFactory() {
  }

  public static DDNonMagicItemFactory getInstance() {
    return INSTANCE;
  }

  @SuppressWarnings("HardCodedStringLiteral")
  @Override
  protected DDOneRarityItemType[] getValues() {
    EDDNonMagicItemFactory factory;
    try {
      factory = EntityUtils.selectRandomRarity(EDDNonMagicItemFactory.values(), p -> true);
    } catch (NoAvailableEntityTypeException e) {
      factory = EDDNonMagicItemFactory.values()[0];
      LOGGER.error("Error while selecting random factory", e);
    }
    return factory.getFactory().getValues();
  }
}
