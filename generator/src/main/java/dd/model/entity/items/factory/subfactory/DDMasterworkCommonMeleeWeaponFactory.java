package dd.model.entity.items.factory.subfactory;

import dd.model.entity.items.characteristics.fields.DDOneRarityItemType;
import dd.model.entity.items.treasures.enums.EDDMasterworkCommonMeleeWeaponFactory;

/**
 * Created by Germain on 01/11/2016.
 */
public class DDMasterworkCommonMeleeWeaponFactory extends DDOneRarityTreasureSubFactory {

  private static final DDMasterworkCommonMeleeWeaponFactory INSTANCE = new DDMasterworkCommonMeleeWeaponFactory();

  private DDMasterworkCommonMeleeWeaponFactory() {
  }

  public static DDMasterworkCommonMeleeWeaponFactory getInstance() {
    return INSTANCE;
  }

  @Override
  protected DDOneRarityItemType[] getValues() {
    return EDDMasterworkCommonMeleeWeaponFactory.values();
  }
}
