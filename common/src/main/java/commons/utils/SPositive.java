package commons.utils;

import commons.utils.exception.ForbiddenValueException;

/**
 * Created by Germain on 28/06/2016.
 */
public class SPositive {

  public static final SPositive ONE = new SPositive(1);

  private final int value;

  public SPositive(int value) {
    if (value <= 0) {
      throw new ForbiddenValueException("The value should be strictly positive");
    }
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}
