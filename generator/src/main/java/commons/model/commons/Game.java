package commons.model.commons;

import org.jetbrains.annotations.NonNls;

/**
 * Created by Germain on 12/06/2016.
 */
public abstract class Game {

  private final String name;

  protected Game(@NonNls String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

}
