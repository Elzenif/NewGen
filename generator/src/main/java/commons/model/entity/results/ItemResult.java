package commons.model.entity.results;

import commons.model.commons.Result;
import commons.model.entity.items.Item;

import java.awt.Color;

import static commons.utils.StringUtils.capitalizeFirstLetter;

/**
 * Created by Germain on 05/06/2016.
 */
public class ItemResult implements Result {

  private final Item item;

  public ItemResult(Item item) {
    this.item = item;
  }

  @Override
  public String getRawResult() {
    return capitalizeFirstLetter(item.toString());
  }

  @Override
  public int getFontStyle() {
    return EItemResultMagic.getItemResultFontStyle(item.getMagic());
  }

  @Override
  public Color getColor() {
    return EItemResultRarity.getItemResultColor(item.getRarity());
  }
}
