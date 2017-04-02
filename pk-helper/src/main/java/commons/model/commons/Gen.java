package commons.model.commons;

/**
 * Created by Germain on 02/04/2017.
 */
public abstract class Gen {

  private final int number;
  private final String romanNumber;

  protected Gen(int nb, String romanNumber) {
    this.number = nb;
    this.romanNumber = romanNumber;
  }

  public int getNumber() {
    return number;
  }

  public String getRomanNumber() {
    return romanNumber;
  }
}
