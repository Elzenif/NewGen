package dd.model.entity.items.factory.subfactory.enums;

import commons.model.entity.characteristics.primary.CustomRarity;
import dd.model.entity.items.characteristics.fields.DDOneRarityItemTypeFactory;
import dd.model.entity.items.factory.subfactory.DDMasterworkCommonMeleeWeaponFactory;
import dd.model.entity.items.factory.subfactory.DDOneRarityTreasureSubFactory;

/**
 * Created by Germain on 01/11/2016.
 */
public enum EDDNonMagicWeaponFactory implements DDOneRarityItemTypeFactory {

  F1(50, DDMasterworkCommonMeleeWeaponFactory.getInstance());

  private final CustomRarity rarity;
  private final DDOneRarityTreasureSubFactory factory;

  EDDNonMagicWeaponFactory(int proba, DDOneRarityTreasureSubFactory factory) {
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
