package mvc.model.entity.results;

/**
 * Created by Germain on 05/06/2016.
 */
public class WeaponResult implements ItemResult {

  private final String result;

  public WeaponResult(String result) {
    this.result = result;
  }

  @Override
  public String getRawResult() {
    return result;
  }
}
