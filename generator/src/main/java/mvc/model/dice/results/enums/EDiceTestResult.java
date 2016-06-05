package mvc.model.dice.results.enums;

import java.awt.Color;

/**
 * Created by Germain on 28/05/2016.
 */
public enum EDiceTestResult {

  NO_TEST(Color.BLACK),
  VALID(new Color(0, 180, 0)),
  INVALID(Color.RED);

  private final Color color;

  EDiceTestResult(Color color) {
    this.color = color;
  }

  public Color getColor() {
    return color;
  }
}
