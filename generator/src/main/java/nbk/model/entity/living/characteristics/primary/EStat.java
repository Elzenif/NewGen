package nbk.model.entity.living.characteristics.primary;

import commons.model.commons.IDrawKeyIntegerValue;
import org.jetbrains.annotations.Contract;

/**
 * Created by Germain on 29/08/2016.
 */
@SuppressWarnings("HardCodedStringLiteral")
public enum EStat implements IDrawKeyIntegerValue {
  COURAGE("COU"),
  INTELLIGENCE("INT"),
  CHARISMA("CHA"),
  AGILITY("AD"),
  STRENGTH("FO");


  private final String name;

  EStat(String name) {
    this.name = name;
  }

  @Contract(pure = true)
  @Override
  public String toString() {
    return name;
  }


  @Override
  public int getMaxValue() {
    return 20;
  }
}
