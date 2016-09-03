package nbk.view.utility.love.result;

import commons.utils.ColorUtils;
import commons.view.utility.result.UtilityResult;

import java.awt.Color;
import java.awt.Font;

/**
 * Created by Germain on 30/07/2016.
 */
public class LovePartResult extends UtilityResult {

  private final String sentence;

  public LovePartResult(String sentence) {
    this.sentence = sentence;
  }

  @Override
  public String getRawResult() {
    return sentence;
  }

  @Override
  public int getFontStyle() {
    return Font.PLAIN;
  }

  @Override
  public Color getColor() {
    return ColorUtils.PINK;
  }

}