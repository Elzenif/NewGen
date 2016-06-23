package commons.model.entity.results;

import commons.model.commons.Result;

import static commons.utils.StringUtils.capitalizeFirstLetter;

/**
 * Created by Germain on 05/06/2016.
 */
public class ItemResult implements Result {

  private final String result;
  private final EItemResultRarity itemResultRarity;

  public ItemResult(String result, EItemResultRarity itemResultRarity) {
    this.result = capitalizeFirstLetter(result);
    this.itemResultRarity = itemResultRarity;
  }

  @Override
  public String getRawResult() {
    return result;
  }

  public EItemResultRarity getItemResultRarity() {
    return itemResultRarity;
  }
}
