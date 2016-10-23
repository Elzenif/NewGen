package commons.view.entity.results.item;

import commons.model.entity.characteristics.primary.enums.EItemRarity;
import commons.model.entity.characteristics.primary.fields.HasRarity;
import commons.utils.ColorUtils;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Germain on 08/06/2016.
 */
enum  EItemResultRarity implements HasRarity {

  COM(EItemRarity.COMMON, ColorUtils.BLACK),
  UNC(EItemRarity.UNCOMMON, ColorUtils.GREEN),
  RAR(EItemRarity.RARE, ColorUtils.BLUE),
  EPI(EItemRarity.EPIC, ColorUtils.PURPLE),
  LEG(EItemRarity.LEGENDARY, ColorUtils.ORANGE);


  private static final Map<EItemRarity, Color> MAP = new HashMap<>(
      Stream.of(EItemResultRarity.values()).
          collect(Collectors.toMap(EItemResultRarity::getRarity, EItemResultRarity::getColor))
  );
  private final EItemRarity rarity;
  private final Color color;

  EItemResultRarity(EItemRarity rarity, Color color) {
    this.rarity = rarity;
    this.color = color;
  }

  public static Color getItemResultColor(EItemRarity rarity) {
    return MAP.get(rarity);
  }

  private Color getColor() {
    return color;
  }

  @Override
  public EItemRarity getRarity() {
    return rarity;
  }

}
