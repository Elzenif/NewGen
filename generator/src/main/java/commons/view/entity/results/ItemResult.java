package commons.view.entity.results;

import commons.model.entity.items.Item;
import commons.utils.StringUtils;
import commons.view.commons.Result;

import java.awt.Color;

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
    return StringUtils.capitalizeFirstLetter(item.toString(), false);
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
