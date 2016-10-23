package nbk.model.utility.love.constraints;

import commons.model.utility.constraints.IUtilityDrawKey;
import org.jetbrains.annotations.Contract;

/**
 * Created by Germain on 24/07/2016.
 */
@SuppressWarnings("SpellCheckingInspection")
public enum ELoveDraw implements IUtilityDrawKey {

  ACTION("Action"),
  TARGET("Cible"),
  TOOL("Avec"),
  POSITION("Position");

  public static final String LOVE_DRAW_NAME = "LD";
  private final String name;

  ELoveDraw(String name) {
    this.name = name;
  }

  @Contract(pure = true)
  @Override
  public String toString() {
    return name;
  }
}
