package mvc.model.dice;

import java.awt.Font;

/**
 * Created by Germain on 22/05/2016.
 */
public enum EDiceResultType {

  NORMAL(Font.PLAIN),
  CRITIC(Font.BOLD),
  FUMBLE(Font.BOLD);

  private int fontStyle;

  EDiceResultType(int fontStyle) {
    this.fontStyle = fontStyle;
  }

  public int getFontStyle() {
    return fontStyle;
  }
}
