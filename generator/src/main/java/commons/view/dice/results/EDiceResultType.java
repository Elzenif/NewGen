package commons.view.dice.results;

import commons.view.utils.Constants;

import java.awt.Font;

/**
 * Created by Germain on 22/05/2016.
 */
public enum EDiceResultType {

  NORMAL(Constants.LITHOGRL_FONT),
  CRITIC(Constants.LITHOGRB_FONT),
  FUMBLE(Constants.LITHOGRB_FONT);

  private final Font font;

  EDiceResultType(Font font) {
    this.font = font;
  }

  public Font getFont() {
    return font;
  }
}
