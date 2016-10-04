package commons.view.dice.results;


import commons.utils.ColorUtils;
import commons.view.utils.Constants;

import java.awt.Color;
import java.awt.Font;

/**
 * Created by Germain on 25/06/2016.
 */
public class AdditionalDiceResult extends AbstractDiceResult {

  private final String result;

  public AdditionalDiceResult(String result) {
    this.result = result;
  }

  @Override
  public String getRawResult() {
    return result;
  }

  @Override
  public Font getFont() {
    return Constants.BENGUIAB_FONT;
  }

  @Override
  public Color getColor() {
    return ColorUtils.BLACK;
  }
}
