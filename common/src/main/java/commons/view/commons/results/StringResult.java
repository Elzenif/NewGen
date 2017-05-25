package commons.view.commons.results;

import commons.Constants;

import java.awt.Color;
import java.awt.Font;

/**
 * Created by Germain on 24/09/2016.
 */
public interface StringResult extends Result<String> {

  default Font getFont() {
    return Constants.DAUPHINN_FONT;
  }

  Color getColor();
}
