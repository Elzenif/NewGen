package utils.exception;

/**
 * Created by Germain on 14/06/2016.
 */
public class WrongClassException extends RuntimeException {
  public WrongClassException(String className) {
    System.out.println("Class " + className + " is not compatible for generation");
  }
}
