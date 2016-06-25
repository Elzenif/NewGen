package commons.model.commons;

import commons.view.utils.Constants;

import java.awt.Color;
import java.awt.Font;

/**
 * Created by Germain on 05/06/2016.
 */
public interface Result {

  String getRawResult();

  default Font getFont() {
   return new Font(Constants.FONT_NAME, getFontStyle(), Constants.FONT_SIZE);
  }

  int getFontStyle();

  Color getColor();
}
