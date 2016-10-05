package commons.utils.exception;

import org.jetbrains.annotations.NonNls;

/**
 * Created by Germain on 17/07/2016.
 */
public class IncompatiblePrimaryClass extends RuntimeException {
  public IncompatiblePrimaryClass(String primaryClassName, String otherClassName) {
    @NonNls String message = "Primary " + primaryClassName + " is not compatible with " + otherClassName;
    System.out.println(message);
  }
}
