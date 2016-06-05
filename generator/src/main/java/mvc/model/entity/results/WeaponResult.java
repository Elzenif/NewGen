package mvc.model.entity.results;

import mvc.model.commons.Result;

/**
 * Created by Germain on 05/06/2016.
 */
public class WeaponResult implements Result {

  private final String result;

  public WeaponResult(String result) {
    this.result = result;
  }

  @Override
  public String getRawResult() {
    return result;
  }
}
