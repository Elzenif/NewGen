package commons.utils.exception;

/**
 * Created by Germain on 24/09/2016.
 */
public class ForbiddenValueException extends RuntimeException {

  public ForbiddenValueException() {
    super("The value should be strictly positive");
  }
}
