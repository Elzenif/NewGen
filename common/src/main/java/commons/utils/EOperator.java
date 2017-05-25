package commons.utils;

/**
 * Created by Germain on 28/05/2016.
 */
public enum EOperator {

  LT("<") {
    public <T> boolean apply(Comparable<T> a, T b) {
      return a.compareTo(b) < 0;
    }
  },
  GT(">") {
    public <T> boolean apply(Comparable<T> a, T b) {
      return a.compareTo(b) > 0;
    }
  },
  LTE("<=") {
    public <T> boolean apply(Comparable<T> a, T b) {
      return a.compareTo(b) <= 0;
    }
  },
  GTE(">=") {
    public <T> boolean apply(Comparable<T> a, T b) {
      return a.compareTo(b) >= 0;
    }
  };

  private final String text;

  EOperator(String text) {
    this.text = text;
  }

  public abstract <T> boolean apply(Comparable<T> a, T b);

  @Override
  public String toString() {
    return text;
  }
}
