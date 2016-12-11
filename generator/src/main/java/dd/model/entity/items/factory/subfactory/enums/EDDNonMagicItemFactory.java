package dd.model.entity.items.factory.subfactory.enums;

import commons.model.entity.characteristics.primary.CustomRarity;
import dd.model.entity.items.characteristics.fields.DDOneRarityItemTypeFactory;
import dd.model.entity.items.factory.subfactory.DDEquipmentFactory;
import dd.model.entity.items.factory.subfactory.DDNonMagicArmorFactory;
import dd.model.entity.items.factory.subfactory.DDNonMagicWeaponFactoryFactory;
import dd.model.entity.items.factory.subfactory.DDOneRarityTreasureSubFactory;
import dd.model.entity.items.factory.subfactory.DDSpecialObjectFactory;

/**
 * Created by Germain on 30/10/2016.
 */
public enum EDDNonMagicItemFactory implements DDOneRarityItemTypeFactory {

  F1(17, DDSpecialObjectFactory.getInstance()),
  F2(33, DDNonMagicArmorFactory.getInstance()),
  F3(33, DDNonMagicWeaponFactoryFactory.getInstance()),
  F4(17, DDEquipmentFactory.getInstance());

  private final CustomRarity rarity;
  private final DDOneRarityTreasureSubFactory factory;

  EDDNonMagicItemFactory(int proba, DDOneRarityTreasureSubFactory factory) {
    this.rarity = new CustomRarity(proba);
    this.factory = factory;
  }

  @Override
  public CustomRarity getRarity() {
    return rarity;
  }

  @Override
  public DDOneRarityTreasureSubFactory getFactory() {
    return factory;
  }
}
