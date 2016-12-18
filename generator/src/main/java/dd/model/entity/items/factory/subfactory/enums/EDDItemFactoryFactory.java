package dd.model.entity.items.factory.subfactory.enums;

import commons.model.entity.characteristics.primary.CustomRarity;
import commons.model.entity.characteristics.primary.fields.HasRarity;
import dd.model.entity.items.characteristics.EDDItemPowerRarityKey;
import dd.model.entity.items.characteristics.fields.DDMultipleRaritiesItemTypeFactory;
import dd.model.entity.items.factory.subfactory.DDMultipleRaritiesTreasureSubFactory;
import dd.model.entity.items.factory.subfactory.DDRingFactory;
import dd.model.entity.items.factory.subfactory.DDWeaponFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Germain on 31/10/2016.
 */
public enum EDDItemFactoryFactory implements DDMultipleRaritiesItemTypeFactory<EDDItemPowerRarityKey> {

  F1(DDRingFactory.getInstance(), 2, 10, 10),
  F2(DDWeaponFactory.getInstance(), 5, 10, 10);

  private final DDMultipleRaritiesTreasureSubFactory factory;
  private final Map<EDDItemPowerRarityKey, HasRarity> map = new HashMap<>();

  EDDItemFactoryFactory(DDMultipleRaritiesTreasureSubFactory factory, int weakProba, int interProba, int powerfulProba) {
    this.factory = factory;
    map.put(EDDItemPowerRarityKey.WEAK, new CustomRarity(weakProba));
    map.put(EDDItemPowerRarityKey.INTERMEDIATE, new CustomRarity(interProba));
    map.put(EDDItemPowerRarityKey.POWERFUL, new CustomRarity(powerfulProba));
  }

  @Override
  public DDMultipleRaritiesTreasureSubFactory getFactory() {
    return factory;
  }

  @Override
  public Map<EDDItemPowerRarityKey, HasRarity> getRarities() {
    return map;
  }
}
