package mvc.model.entity.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by Germain on 08/06/2016.
 */
public enum EGame {

  NBK("Naheulbeuk", true),
  TES("The Elder Scrolls", false);

  private final String name;
  private final boolean isDefault;

  EGame(String name, boolean isDefault) {
    this.name = name;
    this.isDefault = isDefault;
  }

  public String getName() {
    return name;
  }

  public boolean isDefault() {
    return isDefault;
  }

  public static final Map<EGame, String> GAMES = new TreeMap<>(
          Arrays.asList(EGame.values()).stream().collect(Collectors.toMap(Function.identity(), EGame::getName))
  );

  public static EGame defaultGame() {
    return Arrays.asList(EGame.values()).stream().filter(EGame::isDefault).findFirst().orElse(NBK);
  }
}
