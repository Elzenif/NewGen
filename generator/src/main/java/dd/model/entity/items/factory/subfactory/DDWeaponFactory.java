package dd.model.entity.items.factory.subfactory;

import commons.model.entity.utils.EntityUtils;
import commons.utils.exception.NoAvailableEntityTypeException;
import dd.model.entity.items.characteristics.EDDItemPowerRarityKey;
import dd.model.entity.items.characteristics.fields.DDOneRarityItemType;
import dd.model.entity.items.factory.subfactory.enums.EDDNonMagicWeaponFactory;
import dd.model.entity.items.treasures.DDTreasure;
import dd.model.entity.items.treasures.enums.EDDDeadlyArrowTarget;
import dd.model.entity.items.treasures.enums.EDDSpecificWeapon;
import dd.model.entity.items.treasures.enums.EDDWeaponBonus;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Germain on 11/12/2016.
 */
@SuppressWarnings("HardCodedStringLiteral")
public class DDWeaponFactory extends DDMultipleRaritiesTreasureSubFactory {

  private static final Logger LOGGER = LoggerFactory.getLogger(DDWeaponFactory.class);
  private static final DDWeaponFactory INSTANCE = new DDWeaponFactory();

  private DDWeaponFactory() {
  }

  public static DDWeaponFactory getInstance() {
    return INSTANCE;
  }

  @Override
  protected DDTreasure getTreasure(EDDItemPowerRarityKey powerRarityKey) {
    EDDWeaponBonus weaponBonus = getWeaponBonus(powerRarityKey);
    if (weaponBonus == EDDWeaponBonus.SPECIFIC_WEAPON) {
      EDDSpecificWeapon specificWeapon = getSpecificWeapon(powerRarityKey);
      String target = specificWeapon.isDeadlyArrow() ? getDeadlyArrowTarget() : "";
      return new DDTreasure(specificWeapon.getName() + target, specificWeapon.getValue());
    }
    EDDNonMagicWeaponFactory weaponTypeFactory = getNonMagicWeaponFactory();
    DDOneRarityItemType weaponType = getWeaponType(weaponTypeFactory);
    // TODO check if SPECIAL_PROPERTY
    return new DDTreasure(weaponType.getName() + " " + weaponBonus.getName(),
        weaponType.getValue() + " + " + weaponBonus.getValue());
  }

  @NotNull
  private String getDeadlyArrowTarget() {
    String target;
    EDDDeadlyArrowTarget deadlyArrowTarget;
    try {
      deadlyArrowTarget = EntityUtils.selectRandomRarity(EDDDeadlyArrowTarget.values(), p -> true);
    } catch (NoAvailableEntityTypeException e) {
      deadlyArrowTarget = EDDDeadlyArrowTarget.values()[0];
      LOGGER.error("Error while selecting random deadly arrow target", e);
    }
    target = " (" + deadlyArrowTarget.getName() + ")";
    return target;
  }

  private DDOneRarityItemType getWeaponType(EDDNonMagicWeaponFactory weaponTypeFactory) {
    DDOneRarityItemType weaponType;
    try {
      weaponType = EntityUtils.selectRandomRarity(weaponTypeFactory.getFactory().getValues(), p -> true);
    } catch (NoAvailableEntityTypeException e) {
      weaponType = weaponTypeFactory.getFactory().getValues()[0];
      LOGGER.error("Error while selecting random weapon type", e);
    }
    return weaponType;
  }

  private EDDNonMagicWeaponFactory getNonMagicWeaponFactory() {
    EDDNonMagicWeaponFactory weaponTypeFactory;
    try {
      weaponTypeFactory = EntityUtils.selectRandomRarity(EDDNonMagicWeaponFactory.values(), p -> true);
    } catch (NoAvailableEntityTypeException e) {
      weaponTypeFactory = EDDNonMagicWeaponFactory.F1;
      LOGGER.error("Error while selecting random weapon type factory", e);
    }
    return weaponTypeFactory;
  }

  @NotNull
  private EDDSpecificWeapon getSpecificWeapon(EDDItemPowerRarityKey powerRarityKey) {
    EDDSpecificWeapon specificWeapon;
    try {
      specificWeapon = EntityUtils.selectRandomWithCustomRarity(EDDSpecificWeapon.values(), powerRarityKey);
    } catch (NoAvailableEntityTypeException e) {
      specificWeapon = EDDSpecificWeapon.values()[0];
      LOGGER.error("Error while selecting random specific weapon", e);
    }
    return specificWeapon;
  }

  private EDDWeaponBonus getWeaponBonus(EDDItemPowerRarityKey powerRarityKey) {
    EDDWeaponBonus weaponBonus;
    try {
      weaponBonus = EntityUtils.selectRandomWithCustomRarity(EDDWeaponBonus.values(), powerRarityKey);
    } catch (NoAvailableEntityTypeException e) {
      weaponBonus = EDDWeaponBonus.values()[0];
      LOGGER.error("Error while selecting random weapon bonus", e);
    }
    return weaponBonus;
  }
}
