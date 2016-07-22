package commons.utils.exception;

/**
 * Created by Germain on 17/07/2016.
 */
public class IncompatiblePrimaryClass extends RuntimeException {
  public IncompatiblePrimaryClass(String primaryClassName, String otherClassName) {
    System.out.println("Primary " + primaryClassName + " is not compatible with " + otherClassName);
  }
}
