package dd.model.entity.items.factory.subfactory;

import dd.model.entity.items.characteristics.fields.DDOneRarityItemType;
import dd.model.entity.items.treasures.enums.EDDMasterworkUncommonWeapon;

/**
 * Created by Germain on 10/12/2016.
 */
public class DDMasterworkUncommonWeaponFactory extends DDOneRarityTreasureSubFactory {

  private static final DDMasterworkUncommonWeaponFactory INSTANCE = new DDMasterworkUncommonWeaponFactory();

  private DDMasterworkUncommonWeaponFactory() {
  }

  public static DDMasterworkUncommonWeaponFactory getInstance() {
    return INSTANCE;
  }

  @Override
  protected DDOneRarityItemType[] getValues() {
    return EDDMasterworkUncommonWeapon.values();
  }
}
