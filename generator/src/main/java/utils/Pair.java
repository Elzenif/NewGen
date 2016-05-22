package utils;

import java.util.Objects;

/**
 * Created by Germain on 22/05/2016.
 */
public class Pair<L, R> {

  private L left;
  private R rigth;

  public Pair(L left, R rigth) {
    this.left = left;
    this.rigth = rigth;
  }

  public L getLeft() {
    return left;
  }

  public R getRigth() {
    return rigth;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Pair<?, ?> pair = (Pair<?, ?>) o;
    return Objects.equals(left, pair.left) &&
            Objects.equals(rigth, pair.rigth);
  }

  @Override
  public int hashCode() {
    return Objects.hash(left, rigth);
  }
}
