package pk.view;

import commons.Constants;
import org.jetbrains.annotations.Contract;

/**
 * Created by Germain on 10/07/2017.
 */
public enum PkOpponentCriteria {
  NAME(Constants.resourceBundle.getString("name")),
  TYPE(Constants.resourceBundle.getString("type")),
  MOVE(Constants.resourceBundle.getString("move"));

  private final String name;

  PkOpponentCriteria(String name) {
    this.name = name;
  }

  @Contract(pure = true)
  public String getName() {
    return name;
  }


  @Contract(pure = true)
  @Override
  public String toString() {
    return getName();
  }
}
