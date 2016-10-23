package nbk.model.utility.scenario.constraints;

import commons.model.utility.constraints.IUtilityDrawKey;
import org.jetbrains.annotations.Contract;

/**
 * Created by Germain on 30/09/2016.
 */
@SuppressWarnings("SpellCheckingInspection")
public enum EScenarioDraw implements IUtilityDrawKey {

  BEGINNING("Début"),
  GUY("Perso"),
  QUEST("Quête"),
  LOCATION("Lieu"),
  LOOT("Gain");

  public static final String SCENARIO_DRAW_NAME = "SD";
  private final String name;

  EScenarioDraw(String name) {
    this.name = name;
  }

  @Contract(pure = true)
  @Override
  public String toString() {
    return name;
  }
}
