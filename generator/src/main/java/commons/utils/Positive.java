package commons.utils;

import commons.utils.exception.ForbiddenValueException;

/**
 * Created by Germain on 28/06/2016.
 */
public class Positive {

  public static final Positive ONE = new Positive(1);

  private final int value;

  public Positive(int value) {
    if (value < 0) {
      throw new ForbiddenValueException("The value should be positive");
    }
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}
