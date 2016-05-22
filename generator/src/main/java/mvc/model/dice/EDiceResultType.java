package mvc.model.dice;

import java.awt.Color;

/**
 * Created by Germain on 22/05/2016.
 */
public enum EDiceResultType {

  NORMAL(Color.BLACK),
  CRITIC(Color.BLUE),
  FUMBLE(Color.RED);

  private Color color;

  EDiceResultType(Color color) {
    this.color = color;
  }

  public Color getColor() {
    return color;
  }
}
