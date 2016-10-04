package commons.view.entity.results.living;

import commons.model.entity.living.Living;
import commons.utils.ColorUtils;
import commons.utils.StringUtils;
import commons.view.entity.results.EntityResult;

import java.awt.Color;

/**
 * Created by Germain on 28/08/2016.
 */
public class LivingResult extends EntityResult {

  private final Living living;

  public LivingResult(Living living) {
    this.living = living;
  }

  @Override
  public String getRawResult() {
    return StringUtils.capitalizeFirstLetter(living.toString(), false);
  }

  @Override
  public Color getColor() {
    return ColorUtils.BLACK;
  }
}
