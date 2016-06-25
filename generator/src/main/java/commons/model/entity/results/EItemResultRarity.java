package commons.model.entity.results;

import commons.model.commons.HasRarity;
import commons.model.entity.enums.ERarity;
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

  COM(ERarity.COMMON, ColorUtils.BLACK),
  UNC(ERarity.UNCOMMON, ColorUtils.GREEN),
  RAR(ERarity.RARE, ColorUtils.BLUE),
  EPI(ERarity.EPIC, ColorUtils.PURPLE),
  LEG(ERarity.LEGENDARY, ColorUtils.ORANGE);


  private final ERarity rarity;
  private final Color color;

  EItemResultRarity(ERarity rarity, Color color) {
    this.rarity = rarity;
    this.color = color;
  }

  public Color getColor() {
    return color;
  }

  @Override
  public ERarity getRarity() {
    return rarity;
  }

  private static final Map<ERarity, Color> MAP = new HashMap<>(
          Stream.of(EItemResultRarity.values()).
                  collect(Collectors.toMap(EItemResultRarity::getRarity, EItemResultRarity::getColor))
  );

  public static Color getItemResultColor(ERarity rarity) {
    return MAP.get(rarity);
  }

}
