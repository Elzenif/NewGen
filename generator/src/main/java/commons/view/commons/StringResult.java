package commons.view.commons;

import commons.view.utils.Constants;

import java.awt.Color;
import java.awt.Font;

/**
 * Created by Germain on 24/09/2016.
 */
public interface StringResult extends Result<String> {

  default Font getFont() {
    return new Font(Constants.FONT_NAME, getFontStyle(), Constants.FONT_SIZE);
  }

  int getFontStyle();

  Color getColor();
}
