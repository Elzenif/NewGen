package dd.model.entity.items.factory.subfactory;

import dd.model.entity.items.characteristics.fields.DDOneRarityItemType;
import dd.model.entity.items.treasures.enums.EDDMasterworkCommonRangeWeapon;

/**
 * Created by Germain on 10/12/2016.
 */
public class DDMasterworkCommonRangeWeaponFactory extends DDOneRarityTreasureSubFactory {

  private static final DDMasterworkCommonRangeWeaponFactory INSTANCE = new DDMasterworkCommonRangeWeaponFactory();

  private DDMasterworkCommonRangeWeaponFactory() {
  }

  public static DDMasterworkCommonRangeWeaponFactory getInstance() {
    return INSTANCE;
  }

  @Override
  protected DDOneRarityItemType[] getValues() {
    return EDDMasterworkCommonRangeWeapon.values();
  }
}
