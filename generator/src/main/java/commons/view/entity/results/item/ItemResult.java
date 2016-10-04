package commons.view.entity.results.item;

import commons.model.entity.items.Item;
import commons.utils.StringUtils;
import commons.view.entity.results.EntityResult;

import java.awt.Color;

/**
 * Created by Germain on 05/06/2016.
 */
public class ItemResult extends EntityResult {

  private final Item item;

  public ItemResult(Item item) {
    this.item = item;
  }

  @Override
  public String getRawResult() {
    return StringUtils.capitalizeFirstLetter(item.toString(), false);
  }

  @Override
  public Color getColor() {
    return EItemResultRarity.getItemResultColor(item.getRarity());
  }
}
