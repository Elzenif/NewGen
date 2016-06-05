package utils.exception;

/**
 * Created by Germain on 05/06/2016.
 */
public class WrongClassException extends Throwable {
  public WrongClassException(String className) {
    System.out.println("Class " + className + " is not compatible for generation");
  }
}
