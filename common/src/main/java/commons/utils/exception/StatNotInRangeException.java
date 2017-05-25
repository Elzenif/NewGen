package commons.utils.exception;

/**
 * Created by Germain on 29/08/2016.
 */
public class StatNotInRangeException extends Exception {

  public StatNotInRangeException(int value) {
    super(value + " should be in range 8-13");
  }
}
