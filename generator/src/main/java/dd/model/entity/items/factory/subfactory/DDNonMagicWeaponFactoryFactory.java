package dd.model.entity.items.factory.subfactory;

import commons.model.entity.utils.EntityUtils;
import commons.utils.exception.NoAvailableEntityTypeException;
import dd.model.entity.items.characteristics.fields.DDOneRarityItemType;
import dd.model.entity.items.factory.subfactory.enums.EDDNonMagicWeaponFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Germain on 01/11/2016.
 */
public class DDNonMagicWeaponFactoryFactory extends DDOneRarityTreasureSubFactory {

  private static final Logger LOGGER = LoggerFactory.getLogger(DDNonMagicWeaponFactoryFactory.class);
  private static final DDNonMagicWeaponFactoryFactory INSTANCE = new DDNonMagicWeaponFactoryFactory();

  private DDNonMagicWeaponFactoryFactory() {
  }

  public static DDNonMagicWeaponFactoryFactory getInstance() {
    return INSTANCE;
  }

  @SuppressWarnings("HardCodedStringLiteral")
  @Override
  protected DDOneRarityItemType[] getValues() {
    EDDNonMagicWeaponFactory factory;
    try {
      factory = EntityUtils.selectRandomRarity(EDDNonMagicWeaponFactory.values(), p -> true);
    } catch (NoAvailableEntityTypeException e) {
      factory = EDDNonMagicWeaponFactory.values()[0];
      LOGGER.error("Error while selecting random factory");
    }
    return factory.getFactory().getValues();
  }
}
