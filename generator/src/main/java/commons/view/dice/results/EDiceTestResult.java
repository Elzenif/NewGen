package commons.view.dice.results;

import commons.utils.ColorUtils;

import java.awt.Color;

/**
 * Created by Germain on 28/05/2016.
 */
public enum EDiceTestResult {

  NO_TEST(ColorUtils.BLACK),
  VALID(ColorUtils.GREEN),
  INVALID(ColorUtils.RED);

  private final Color color;

  EDiceTestResult(Color color) {
    this.color = color;
  }

  public Color getColor() {
    return color;
  }
}
