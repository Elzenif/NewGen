package dd.model.entity.items.factory.subfactory;

import dd.model.entity.items.characteristics.fields.DDOneRarityItemType;
import dd.model.entity.items.treasures.enums.EDDNonMagicArmor;

/**
 * Created by Germain on 31/10/2016.
 */
public class DDNonMagicArmorFactory extends DDOneRarityTreasureSubFactory {

  private static final DDNonMagicArmorFactory INSTANCE = new DDNonMagicArmorFactory();

  private DDNonMagicArmorFactory() {
  }

  public static DDNonMagicArmorFactory getInstance() {
    return INSTANCE;
  }

  @Override
  protected DDOneRarityItemType[] getValues() {
    return EDDNonMagicArmor.values();
  }
}
