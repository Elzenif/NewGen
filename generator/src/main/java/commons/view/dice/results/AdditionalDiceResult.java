package commons.view.dice.results;


import commons.utils.ColorUtils;

import java.awt.Color;
import java.awt.Font;

/**
 * Created by Germain on 25/06/2016.
 */
public class AdditionalDiceResult implements AbstractDiceResult {

  private final String result;

  public AdditionalDiceResult(String result) {
    this.result = result;
  }

  @Override
  public String getRawResult() {
    return result;
  }

  @Override
  public int getFontStyle() {
    return Font.BOLD;
  }

  @Override
  public Color getColor() {
    return ColorUtils.BLACK;
  }
}
