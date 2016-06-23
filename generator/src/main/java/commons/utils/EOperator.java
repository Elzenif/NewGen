package commons.utils;

/**
 * Created by Germain on 28/05/2016.
 */
public enum EOperator {

  LT("<") {
    @Override
    public boolean apply(int a, int b) {
      return a < b;
    }
  },
  GT(">") {
    public boolean apply(int a, int b) {
      return a > b;
    }
  },
  LTE("<=") {
    public boolean apply(int a, int b) {
      return a <= b;
    }
  },
  GTE(">=") {
    public boolean apply(int a, int b) {
      return a >= b;
    }
  };

  private final String text;

  EOperator(String text) {
    this.text = text;
  }

  public abstract boolean apply(int a, int b);

  @Override
  public String toString() {
    return text;
  }
}
