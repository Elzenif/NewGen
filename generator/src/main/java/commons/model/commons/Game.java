package commons.model.commons;

/**
 * Created by Germain on 12/06/2016.
 */
public abstract class Game {

  private final String name;

  protected Game(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

}
